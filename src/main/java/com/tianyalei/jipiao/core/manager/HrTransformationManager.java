package com.tianyalei.jipiao.core.manager;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tianyalei.jipiao.core.controller.HrTransformationController;
import com.tianyalei.jipiao.core.model.*;
import com.tianyalei.jipiao.core.repository.*;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
import com.tianyalei.jipiao.global.util.CommonUtil;
import com.xiaoleilu.hutool.date.DateTime;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.BeanUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.apache.commons.collections4.ListUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.xmlbeans.impl.jam.mutable.MMember;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HrTransformationManager {

    @Resource
    private HrOrganizationRepository hrOrganizationRepository;

    @Resource
    private HrDepartmentRepository hrDepartmentRepository;

    @Resource
    private CompanyRepository companyRepository;

    @Resource
    private CompanyDepartmentRepository companyDepartmentRepository;

    @Resource
    private DictCache dictCache;

    @Resource
    private HrEmployeeRepository hrEmployeeRepository;

    @Resource
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private MemberCardNumManager memberCardNumManager;

    @Resource
    private MemberExtendManager memberExtendManager;

    @Resource
    private MemberCallManager memberCallManager;
    /**
     * 分页列表
     * @param entity
     * @param page
     * @param size
     * @return
     */
    public SimplePage<MHrOrganizationEntity> findAll(MHrOrganizationEntity entity, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, "OrgId")
        );
        Page<MHrOrganizationEntity> all = hrOrganizationRepository.findAll(new Specification<MHrOrganizationEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MHrOrganizationEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = null;
                if (entity.getOrgId() != null && !entity.getOrgId().equals("")) {
                    p1 = criteriaBuilder.and(p1, criteriaBuilder.equal(root.get("OrgID"), entity.getOrgId()));
                }
                if (entity.getOrgName() != null && !entity.getOrgName().equals("")) {
                    p1 = criteriaBuilder.and(p1, criteriaBuilder.equal(root.get("OrgName"), entity.getOrgName()));
                }
                if (entity.getPanelname() != null && !entity.getPanelname().equals("")) {
                    p1 = criteriaBuilder.and(p1, criteriaBuilder.equal(root.get("Panelname"), entity.getPanelname()));
                }
                return p1;
            }
        }, pageable);
        return new SimplePage<>(all.getTotalPages(), all
                .getTotalElements(), all.getContent());
    }

    /**
     * 树数据获取
     *  1.第一次请求没有最高父级id，查询所有树顶级
     *  2.存在树顶级，查询所有树下所有树
     * @param orgId
     * @return
     */
    public List<RegionBeanTree> findTree(String orgId) {

        List<Object[]> sonList = hrOrganizationRepository.findSonList(orgId);
        if(sonList == null || sonList.size() == 0){
            return new ArrayList<>();
        }
        //转换数据
        List<RegionBeanTree> resultList = new ArrayList<>();
        for(Object[] o : sonList){
            RegionBeanTree r = new RegionBeanTree((String) o[0],(String) o[1],(Byte) o[2],(String) o[3]);
            resultList.add(r);
        }
        //拼装树
        Map<String, RegionBeanTree> rMap = new LinkedHashMap<>();
        for (RegionBeanTree thisN : resultList) {
            RegionBeanTree.turnToMap(rMap, thisN);// 构建一颗逻辑树
        }
        RegionBeanTree root = new RegionBeanTree();// 结果树
        RegionBeanTree.turnToList(rMap, root);// 递归解析map树，并放入root这个根节点中
        return root.getChildren();
    }
    /**
     * root 树
     * @return
     */
    public List<RegionBeanTree> findFatherTree() {
        List<Object[]> fatherId = hrOrganizationRepository.findFatherId();
        if(fatherId == null || fatherId.size() == 0)
            return new ArrayList<>();
        List<RegionBeanTree> resultList = new ArrayList<>();
        //转换树
        for(Object[] o : fatherId){
            RegionBeanTree r = new RegionBeanTree((String) o[0],(String) o[1],(Byte) o[2],(String) o[3]);
            resultList.add(r);
        }
        return resultList;
    }

    /**
     * 获取orgid下的等级数据
     * @param orgId
     * @return
     */
    public List<RegionBeanTree> findTFCompanyList(String orgId) {
        List<Object[]> sonList = hrOrganizationRepository.findByLevelList(orgId,getLeve(orgId)+1);
        //转换数据
        List<RegionBeanTree> resultList = new ArrayList<>();
        for(Object[] o : sonList){
            RegionBeanTree r = new RegionBeanTree((String) o[0],(String) o[1],(Byte) o[2],(String) o[3]);
            resultList.add(r);
        }
        return resultList;
    }

    /**
     * id 计算等级
     * @param orgId
     * @return
     */
    private static Integer getLeve(String orgId){
        if(orgId.length() == 2){
            return 1;
        }else if(orgId.length() == 4){
            return 2;
        }else{
            return (orgId.length() - 6) / 4 + 3;
        }
    }

    /**
     * 新增转换数据
     * @param entity
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public String add(TFEntity entity){
        //是否有重复数据
        List<String> list = new ArrayList<>();
        for (RegionBeanTree r : entity.gettFCompany()){
            list.add(r.getLabel());
        }
        List<Object[]> objects = companyRepository.findByCompanyNameiIn(list);

        if(objects != null && objects.size() > 0)
            return "您选择的单位"+JSONObject.toJSONString(objects)+"已经存在";
        if(entity.getUpCompany() == null || entity.equals("")){//默认第一级单位
            entity.setUpCompany(0);
            getConmpany(entity);
        }else{//新增单位
            getConmpany(entity);
        }
        return "转换单位成功";
    }

    /**
     * 新增部门数据
     * @param companyId 新增的部门id
     * @param orgId 转换之前的部门id
     * @param tf 传参
     */
    private void getDept(Integer companyId,String orgId,TFEntity tf){
        //获取orgId下的所有部门
        List<MHrDepartmentEntity> hrEntity = hrDepartmentRepository.findByOrgId(orgId);
        for(MHrDepartmentEntity m : hrEntity){
            MCompanyDepartmentEntity entity = new MCompanyDepartmentEntity();
            entity.setDepartmentName(m.getDepName());//DepName
            entity.setIsDeptApprove(false);
            entity.setApproveType(dictCache.findByGroupIdAndKey(61,tf.getApproveType()));
            entity.setHrDeptId(m.getDepId());//depId
            entity.setIsEnable(true);
            entity.setCompanyId(companyId);
            entity.setCreateRealName(tf.getCreateRealName());
            entity.setCreateTime(tf.getCreateTime());
            entity.setCreateUserId(tf.getCreateUserId());
            entity.setUpdateTime(tf.getUpdateTime());
            add(entity);
        }
    }

    /**
     * 新增单位
     * @param tf 传参
     */
    private void getConmpany(TFEntity tf){
        List<RegionBeanTree> list = tf.gettFCompany();
        for(RegionBeanTree r : list){
            //新增单位

            MCompanyEntity entity = new MCompanyEntity();
            entity.setCompanyName(r.getLabel());
            entity.setSimpleName(r.getLabel());
            entity.setParentId(tf.getUpCompany().toString());
            entity.setPinYin(convertHanzi2Pinyin(r.getLabel(),false).toUpperCase());
            /*entity.setTelphone("");
            entity.setFax("");
            entity.setAddress("");*/
            entity.setAvailScore(0);
            entity.setTotScore(0);
            entity.setRemark(tf.getRemark());
            entity.setLevel(r.getLeve());
            entity.setServerType(dictCache.findByGroupIdAndKey(58,tf.getServerType()));
            entity.setServerCost(tf.getServerCost());
            entity.setSendMessageType(dictCache.findByGroupIdAndKey(59,tf.getSendMessageType()));
            entity.setPolicyType(dictCache.findByGroupIdAndKey(60,tf.getPolicyType()));
            entity.setDebtTime(tf.getDebtTime());
            entity.setPanelname(r.getPanelname());
            entity.setIsBalance(tf.isBalance());
            entity.setIsEnable(true);
            entity.setApproveType(dictCache.findByGroupIdAndKey(61,tf.getApproveType()));
            entity.setTravelControlType(dictCache.findByGroupIdAndKey(55,tf.getTravelControlType()));
            entity.setCreateRealName(tf.getCreateRealName());
            entity.setCreateUserId(tf.getCreateUserId());
            entity.setCreateTime(tf.getCreateTime());
            entity.setUpdateTime(tf.getUpdateTime());
            entity.setHrOrgId(r.getCode());
            Optional<MHrOrganizationEntity> byId = hrOrganizationRepository.findById(r.getCode());
            entity.setAccountBookCode(byId.get().getAccountCode());
            entity = add(entity);
            //新增部门
            if(tf.isTF()){
                getDept(entity.getId(),r.getCode(),tf);
            }
        }

    }

    private MCompanyEntity add(MCompanyEntity o){
        return companyRepository.save(o);
    }
    private MCompanyDepartmentEntity add(MCompanyDepartmentEntity o){
        return companyDepartmentRepository.save(o);
    }

    /**
     * 将汉字转成拼音
     * <P>
     * 取首字母或全拼
     *
     * @param hanzi 汉字字符串
     * @param isFull 是否全拼 true:表示全拼 false表示：首字母
     *
     * @return 拼音
     */
    private static String convertHanzi2Pinyin(String hanzi,boolean isFull){
        /***
         * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言
         * ^[\u4E00-\u9FFF]+$ 匹配简体和繁体
         * ^[\u4E00-\u9FA5]+$ 匹配简体
         */
        String regExp="^[\u4E00-\u9FFF]+$";
        StringBuffer sb=new StringBuffer();
        if(hanzi==null||"".equals(hanzi.trim())){
            return "";
        }
        String pinyin="";
        for(int i=0;i<hanzi.length();i++){
            char unit=hanzi.charAt(i);
            //是汉字，则转拼音
            Matcher matcher = Pattern.compile(regExp).matcher(String.valueOf(unit));
            if(matcher.find()){
                HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
                outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
                String[] res;
                StringBuffer sb1 = new StringBuffer();
                try {
                    res = PinyinHelper.toHanyuPinyinStringArray(unit,outputFormat);
                    sb1.append(res[0]);//对于多音字，只用第一个拼音
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pinyin = sb1.toString();
                if(isFull){
                    sb.append(pinyin);
                }
                else{
                    sb.append(pinyin.charAt(0));
                }
            }else{
                sb.append(unit);
            }
        }
        return sb.toString();
    }

    /**
     * 转换人员列表
     * @param entity
     * @param page
     * @param size
     */
    public Page<EmployeeListEntity> findList(EmployeeListEntity entity, Integer page, Integer size) {
        Pageable pageable = new PageRequest(page,size);
        long total = hrEmployeeRepository.findByCountAll();
        //高级查询
        StringBuffer sql = new StringBuffer("SELECT " +
                "a.EmployeeID," +
                "a.RealName," +
                "o.OrgName," +
                "c.DepName," +
                "a.PaperNum," +
                "a.PhoneNum," +
                "a.Position," +
                "a.AdministrativeLevel," +
                "a.TravelLevel" +
                " FROM " +
                "M_HREmployee a " +
                "LEFT JOIN M_HRRelational b ON a.EmployeeID = b.EmployeeID " +
                "LEFT JOIN M_HRDepartment c ON c.DepID = b.DeptID " +
                "LEFT JOIN M_HROrganization o ON c.OrgID = o.OrgID");
        if (entity.getOrgName() != null && !entity.getOrgName().equals("")) {
            sql.append(where(sql.toString()) + "o.OrgName like '" + entity.getOrgName() + "%'");
        }
        if (entity.getRealName() != null && !entity.getRealName().equals("")) {
            sql.append(where(sql.toString()) + "a.RealName like '" + entity.getRealName() + "%'");
        }
        if (entity.getHrCode() != null && !entity.getHrCode().equals("")) {
            sql.append(where(sql.toString()) + "a.HRCode = " + entity.getHrCode() + "");
        }
        sql.append(" ORDER BY a.EmployeeID LIMIT " + pageable.getOffset() + "," + pageable.getPageSize() + "");
        List<Object[]> list = entityManager.createNativeQuery(sql.toString()).getResultList();
        //转换实体
        List<EmployeeListEntity> listEntities = new ArrayList<>();
        list.stream().forEach(o ->{
            listEntities.add(new EmployeeListEntity(
                    (String) o[0],
                    (String) o[1],
                    (String) o[2],
                    (String) o[3],
                    (String) o[4],
                    (String) o[5],
                    (String) o[6],
                    (String) o[7],
                    (Byte) o[8])
            );
        });
        Page<EmployeeListEntity> pageList = new PageImpl<>(listEntities,pageable,total);
        return pageList;
    }

    private static String where(String sql){
        if(sql.indexOf("WHERE") != -1 || sql.indexOf("AND") != -1){
            return " AND ";
        }else {
            return " WHERE ";
        }
    }

    /**
     * 职工转换查询
     * @param orgId
     * @return
     */
    public List<EmployeeListEntity> findEmp(String orgId) {
        List<Object[]> list = hrEmployeeRepository.findByOrgId(orgId);
        List<EmployeeListEntity> listEntities = new ArrayList<>();
        list.stream().forEach(o ->{
            listEntities.add(new EmployeeListEntity(
                    (String) o[0],
                    (String) o[1],
                    (String) o[2],
                    (String) o[3],
                    (String) o[4],
                    (Byte) o[5]));
        });
        return listEntities;
    }

    /**
     * 人员转换
     * @param empList
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public String add(EmployeeListEntity entity) {
        List<String> list = new ArrayList<>();
        //查询选择的转换人员数据
        List<MHrEmployeeEntity> listEmp = hrEmployeeRepository.findByEmployeeIdIn(entity.getEmpList());
        listEmp.stream().forEach(emp -> {
            try{
                getMMemberEntity(emp, entity);
            }catch (RuntimeException e){
                list.add(emp.getEmployeeId());
            }

        });
        if(list != null && list.size() > 0){
            //返回流
            return "转换职员错误：验证不通过"+JSONObject.toJSONString(list);
        }
        return "转换职员成功";
    }

    private void getMMemberEntity(MHrEmployeeEntity emp,EmployeeListEntity entity){
        //验证一些数据CommonUtil.aesDecode(
        String phoneRegex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        boolean phone = Pattern.compile(phoneRegex).matcher(emp.getPhoneNum()).matches();
        String idCadRegex = "[1-9]{2}[0-9]{4}(19|20)[0-9]{2}((0[1-9]{1})|(1[1-2]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1}|(3[0-1]{1})))[0-9]{3}[0-9Xx]{1}";
        boolean idCad = Pattern.compile(idCadRegex).matcher(emp.getPaperNum()).matches();
        String emailRegex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        boolean email = emp.getEmail() == null || emp.getEmail().equals("") ? true : Pattern.compile(emailRegex).matcher(emp.getEmail()).matches();
        if(!phone || !idCad || !email){
            throw new RuntimeException();
        }

        MMemberEntity m = new MMemberEntity();
        m.setMemberType("2");
        Map<String, String> map = CommonUtil.getBirAgeSex(emp.getPaperNum());
        m.setBirthday(DateUtil.parse(map.get("birthday")));
        m.setGender(Byte.valueOf(map.get("sexCode")));
        m.setPersonnelType("1");
        m.setMemberClass("1");
        m.setCountry("CN");
        m.setNation("");
        m.setIsSecretary("0");
        m.setTicketOfficeId(1);
        m.setMemberFrom("10");
        m.setIsEnable(true);

        m.setCardNum(memberCardNumManager.findFirstCardNum().getCardNum());
        m.setDepartmentId(hrEmployeeRepository.findByDeparmentId(emp.getEmployeeId()));
        hrEmployeeRepository.findByTraveLevel(entity.getCompanyID(),emp.getTravelLevel());

        m.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        m.setCompanyId(entity.getCompanyID());
        m.setPassengerName(emp.getRealName());
        m.setCellPhone(emp.getPhoneNum());
        m.setRealName(emp.getRealName());
        m.setPosition(emp.getPosition());
        m.setJobTitle(emp.getJobTitle());
        m.setAdministrativeLevel(emp.getAdministrativeLevel());
        m.setPaperNum(emp.getPaperNum());
        m.setEmail(emp.getEmail());

        MemberAddRequestModel model = new MemberAddRequestModel();
        model.setCardNum(m.getCardNum());
        model.setRemark(entity.getRemark());
        model.setCellPhone(m.getCellPhone());
        //删除cardNum的数据
        memberCardNumManager.deleteByCardNum(m.getCardNum());
        //处理memberExtend表
        memberExtendManager.parse(model);
        //处理memberCall表
        memberCallManager.parse(model);
        System.err.println(JSONObject.toJSONString(m));
        add(m);
    }
    private MMemberEntity add(MMemberEntity member){
        return memberRepository.save(member);
    }

}
