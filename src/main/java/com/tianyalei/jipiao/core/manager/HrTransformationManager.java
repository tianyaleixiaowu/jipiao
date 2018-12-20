package com.tianyalei.jipiao.core.manager;

import com.alibaba.fastjson.JSONObject;
import com.tianyalei.jipiao.core.model.*;
import com.tianyalei.jipiao.core.repository.CompanyDepartmentRepository;
import com.tianyalei.jipiao.core.repository.CompanyRepository;
import com.tianyalei.jipiao.core.repository.HrDepartmentRepository;
import com.tianyalei.jipiao.core.repository.HrOrganizationRepository;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.apache.commons.collections4.ListUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
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
            entity = add(entity);
            //新增部门
            if(tf.isTF()){
                getDept(entity.getId(),r.getCode(),tf);
            }
        }

    }

    public MCompanyEntity add(MCompanyEntity o){
        return companyRepository.save(o);
    }
    public MCompanyDepartmentEntity add(MCompanyDepartmentEntity o){
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
            if(match(String.valueOf(unit),regExp)){
                pinyin=convertSingleHanzi2Pinyin(unit);
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
     * 将单个汉字转成拼音
     *
     * @param hanzi 汉字字符
     *
     * @return 拼音
     */
    private static String convertSingleHanzi2Pinyin(char hanzi){
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String[] res;
        StringBuffer sb=new StringBuffer();
        try {
            res = PinyinHelper.toHanyuPinyinStringArray(hanzi,outputFormat);
            sb.append(res[0]);//对于多音字，只用第一个拼音
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    /***
     * 匹配
     * <P>
     * 根据字符和正则表达式进行匹配
     *
     * @param str 源字符串
     * @param regex 正则表达式
     *
     * @return true：匹配成功  false：匹配失败
     */
    private static boolean match(String str,String regex){
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        return matcher.find();
    }


}
