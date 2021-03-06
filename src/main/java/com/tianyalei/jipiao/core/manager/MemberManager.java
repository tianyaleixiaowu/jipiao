package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.core.model.MMemberEntity;
import com.tianyalei.jipiao.core.repository.MemberRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.core.request.MemberQueryRequestQueryModel;
import com.tianyalei.jipiao.core.response.MemberListResponseVO;
import com.tianyalei.jipiao.core.response.MemberSingleResponseVO;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
import com.tianyalei.jipiao.global.specify.Criteria;
import com.tianyalei.jipiao.global.specify.Restrictions;
import com.tianyalei.jipiao.global.util.CheckIdCardUtils;
import com.tianyalei.jipiao.global.util.CommonUtil;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricCrypto;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.BeanUtil;
import com.xiaoleilu.hutool.util.CharsetUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberManager {
    @Resource
    private MemberRepository memberRepository;
    @Resource
    private MemberCardNumManager memberCardNumManager;
    @Resource
    private CompanyManager companyManager;
    @Resource
    private CompanyDepartmentManager companyDepartmentManager;
    @Resource
    private CompanyTravelLevelManager companyTravelLevelManager;
    @Resource
    private MemberCallManager memberCallManager;
    @Resource
    private MemberExtendManager memberExtendManager;
    @Resource
    private MemberSingleManager memberSingleManager;
    @Resource
    private MemberBalanceCompanyManager memberBalanceCompanyManager;
    @Resource
    private DictCache dictCache;


    public BaseData addOrUpdate(MemberAddRequestModel memberAddRequestModel, boolean add) {
        //身份证号验证,强验证
        if(!CheckIdCardUtils.validateCard(memberAddRequestModel.getPaperNum())){
            return ResultGenerator.genFailResult("请输入正确身份证");
        }
        //添加时查重
        if (add ) {
            String newPhone = CommonUtil.aesEncode(memberAddRequestModel.getCellPhone());
            MMemberEntity entity = memberRepository.findFirstByCellPhone(newPhone);
            if (entity != null) {
                return ResultGenerator.genFailResult("手机号重复");
            }
        }

        if (StringUtils.isEmpty(memberAddRequestModel.getCardNum())) {
            memberAddRequestModel.setCardNum(memberCardNumManager.findFirstCardNum().getCardNum());
        }
        MMemberEntity mMemberEntity = memberRepository.findByCardNum(memberAddRequestModel.getCardNum());
        if (mMemberEntity == null) {
            mMemberEntity = new MMemberEntity();
        }else{
            memberCallManager.parseUpdate(memberAddRequestModel);
        }

        BeanUtil.copyProperties(memberAddRequestModel, mMemberEntity);
        mMemberEntity.setCellPhone(CommonUtil.aesEncode(memberAddRequestModel.getCellPhone()));
        mMemberEntity.setBackupCellPhone(CommonUtil.aesEncode(memberAddRequestModel.getBackupCellPhone()));
        mMemberEntity.setPaperNum(CommonUtil.aesEncode(memberAddRequestModel.getPaperNum()));
        mMemberEntity.setPhoneNum(CommonUtil.aesEncode(memberAddRequestModel.getPhoneNum()));

        Map<String, String> map = CommonUtil.getBirAgeSex(memberAddRequestModel.getPaperNum());
        //mMemberEntity.setBirthday(DateUtil.parse(map.get("birthday")));
        try {
            mMemberEntity.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("birthday")));
        }catch (ParseException e){
            e.printStackTrace();
        }
        mMemberEntity.setGender(Byte.valueOf(map.get("sexCode")));
        //mMemberEntity.setBirthday(DateUtil.parse(memberAddRequestModel.getBirthday()));

        //删除cardNum的数据
        memberCardNumManager.deleteByCardNum(memberAddRequestModel.getCardNum());
        //处理memberCall表
        //memberCallManager.parse(memberAddRequestModel);
        //处理memberExtend表
        memberExtendManager.parse(memberAddRequestModel);

        //个人用户禁用所有CardNum关联的M_MemberBalanceCompany
        if ("1".equals(memberAddRequestModel.getMemberType())) {
            memberBalanceCompanyManager.updateEnable(memberAddRequestModel.getCardNum(),new Byte("0"));
        }
        //企业用户启用所有的M_MemberBalanceCompany
        if ("2".equals(memberAddRequestModel.getMemberType())) {
            //如果会员类型选择为企业会员, 也要把所选单位默认设置为会员的结算单位 M_MemberBalanceCompany
            memberBalanceCompanyManager.addOrUpdate(memberAddRequestModel);
            memberBalanceCompanyManager.updateEnable(memberAddRequestModel.getCardNum(),new Byte("1"));
        }
        if (add) {
            memberCallManager.parse(memberAddRequestModel);
            mMemberEntity = memberSingleManager.add(mMemberEntity);
        } else {
            mMemberEntity = memberSingleManager.update(mMemberEntity);
        }

        return ResultGenerator.genSuccessResult(mMemberEntity);
    }


    public MMemberEntity save(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }

    public void delete(String cardNum) {
        MMemberEntity mMemberEntity = find(cardNum);
        mMemberEntity.setIsEnable(false);
        delete(mMemberEntity);
    }

    public void delete(MMemberEntity mMemberEntity) {
        save(mMemberEntity);
    }


    public MMemberEntity find(String cardNum) {
        return memberRepository.findByCardNum(cardNum);
    }

    /**
     * 根据cardNum找到一个
     *
     * @param cardNum
     *         cardNum
     * @return MemberSingleResponseVO
     */
    public MemberSingleResponseVO findOne(String cardNum) {
        MMemberEntity entity = find(cardNum);
        MemberSingleResponseVO singleResponseVO = new MemberSingleResponseVO();
        BeanUtil.copyProperties(entity, singleResponseVO);
        singleResponseVO.setCompanyIdValue(companyManager.findName(entity.getCompanyId()));
        singleResponseVO.setDepartmentIdValue(companyDepartmentManager.findName(entity.getDepartmentId()));
        MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity = memberBalanceCompanyManager.findByCardNumAndCompanyId
                (cardNum, entity.getCompanyId());
        if (mMemberBalanceCompanyEntity != null) {
            singleResponseVO.setTravelLevelId(mMemberBalanceCompanyEntity.getTravelLevelId());
            singleResponseVO.setTravelLevelIdValue(companyTravelLevelManager.findName(mMemberBalanceCompanyEntity
                    .getTravelLevelId()));
        }
        singleResponseVO.setCellPhone(CommonUtil.aesDecode(entity.getCellPhone()));
        singleResponseVO.setBackupCellPhone(CommonUtil.aesDecode(entity.getBackupCellPhone()));
        singleResponseVO.setPaperNum(CommonUtil.aesDecode(entity.getPaperNum()));
        singleResponseVO.setPhoneNum(CommonUtil.aesDecode(entity.getPhoneNum()));
        singleResponseVO.setBirthday(DateUtil.format(entity.getBirthday(), DatePattern.NORM_DATE_FORMAT));
        //remark
        singleResponseVO.setRemark(memberExtendManager.findRemarkByCardNum(cardNum));

        return singleResponseVO;
    }


    public SimplePage<MemberListResponseVO> list(MemberQueryRequestQueryModel memberQueryRequestModel) {
        Criteria<MMemberEntity> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("cardNum", memberQueryRequestModel.getCardNum(), true));
        criteria.add(Restrictions.eq("memberType", memberQueryRequestModel.getMemberType(), true));
        criteria.add(Restrictions.eq("companyId", memberQueryRequestModel.getCompanyId(), true));
        criteria.add(Restrictions.eq("hrCode", memberQueryRequestModel.getHrCode(), true));
        if (!StringUtils.isEmpty(memberQueryRequestModel.getPaperNum())) {
            //身份证号是加密的
            criteria.add(Restrictions.eq("paperNum", CommonUtil.aesEncode(memberQueryRequestModel.getPaperNum()),
                    true));
        }
        if (!StringUtils.isEmpty(memberQueryRequestModel.getCellPhone())) {
            //身份证号是加密的
            criteria.add(Restrictions.eq("cellPhone", CommonUtil.aesEncode(memberQueryRequestModel.getCellPhone()),
                    true));
        }
        criteria.add(Restrictions.eq("administrativeLevel", memberQueryRequestModel.getAdministrativeLevel(), true));
        criteria.add(Restrictions.eq("position", memberQueryRequestModel.getPosition(), true));
        criteria.add(Restrictions.eq("isEnable", memberQueryRequestModel.getIsEnable(), true));
        if (memberQueryRequestModel.getIsVip() != null) {
            if (memberQueryRequestModel.getIsVip()) {
                criteria.add(Restrictions.eq("memberClass", "3", true));
            } else {
                criteria.add(Restrictions.ne("memberClass", "3", true));
            }
        }
        if (!StringUtils.isEmpty(memberQueryRequestModel.getRealName())) {
            if (memberQueryRequestModel.isFuzzy()) {
                criteria.add(Restrictions.like("realName", memberQueryRequestModel.getRealName(), true));
            } else {
                criteria.add(Restrictions.eq("realName", memberQueryRequestModel.getRealName(), true));
            }
        }
        Pageable pageable = PageRequest.of(memberQueryRequestModel.getPage(), memberQueryRequestModel.getSize(), Sort
                .Direction.DESC, "createTime");

        Page<MMemberEntity> ecContactEntities = memberRepository.findAll(criteria, pageable);
        return new SimplePage<>(ecContactEntities.getTotalPages(), ecContactEntities.getTotalElements(),
                ecContactEntities.getContent().stream().map(this::parseMemberVO).collect(Collectors.toList()));
    }

    private MemberListResponseVO parseMemberVO(MMemberEntity mMemberEntity) {
        MemberListResponseVO memberListResponseVO = new MemberListResponseVO();
        BeanUtil.copyProperties(mMemberEntity, memberListResponseVO);
        memberListResponseVO.setMemberTypeValue(dictCache.findByGroupId(7).get(memberListResponseVO.getMemberType()));
        memberListResponseVO.setCompanyIdValue(companyManager.findName(memberListResponseVO.getCompanyId()));
        memberListResponseVO.setCellPhone(CommonUtil.aesDecode(memberListResponseVO.getCellPhone()));
        memberListResponseVO.setPositionValue(dictCache.findByGroupId(49).get(memberListResponseVO.getPosition()));
        memberListResponseVO.setAdministrativeLevelValue(dictCache.findByGroupId(31).get(memberListResponseVO
                .getAdministrativeLevel()));
        return memberListResponseVO;
    }

    public List<MMemberEntity> findAll() {
        return memberRepository.findAll();
    }


    public static void main(String[] args) {
        String s = "123";
        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES);
        //加密
        byte[] encrypt = aes.encrypt(s);
        System.out.println(new String(encrypt));

        String encryptHex = aes.encryptHex(s);
        System.out.println(aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8));
    }
}
