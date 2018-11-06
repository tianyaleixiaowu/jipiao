package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberEntity;
import com.tianyalei.jipiao.core.repository.MemberRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.core.request.MemberQueryRequestQueryModel;
import com.tianyalei.jipiao.core.response.MemberVO;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
import com.tianyalei.jipiao.global.specify.Criteria;
import com.tianyalei.jipiao.global.specify.Restrictions;
import com.tianyalei.jipiao.global.util.CommonUtil;
import com.xiaoleilu.hutool.crypto.symmetric.AES;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricCrypto;
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
import java.util.List;
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
    private MemberCallManager memberCallManager;
    @Resource
    private MemberExtendManager memberExtendManager;
    @Resource
    private MemberBalanceCompanyManager memberBalanceCompanyManager;
    @Resource
    private DictCache dictCache;

    private MMemberEntity add(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }

    public MMemberEntity addOrUpdate(MemberAddRequestModel memberAddRequestModel, boolean add) {
        MMemberEntity mMemberEntity = new MMemberEntity();
        BeanUtil.copyProperties(memberAddRequestModel, mMemberEntity);
        mMemberEntity.setCellPhone(CommonUtil.aesEncode(memberAddRequestModel.getCellPhone()));
        mMemberEntity.setBackupCellPhone(CommonUtil.aesEncode(memberAddRequestModel.getBackupCellPhone()));
        mMemberEntity.setPaperNum(CommonUtil.aesEncode(memberAddRequestModel.getPaperNum()));
        mMemberEntity.setBirthday(DateUtil.parse(memberAddRequestModel.getBirthday()));

        //删除cardNum的数据
        memberCardNumManager.deleteByCardNum(memberAddRequestModel.getCardNum());
        //处理memberCall表
        memberCallManager.parse(memberAddRequestModel);
        //处理memberExtend表
        memberExtendManager.parse(memberAddRequestModel);

        //如果会员类型选择为企业会员, 也要把所选单位默认设置为会员的结算单位 M_MemberBalanceCompany
        if ("2".equals(memberAddRequestModel.getMemberType())) {
            memberBalanceCompanyManager.parse(memberAddRequestModel);
        }
        if (add) {
            add(mMemberEntity);
        } else {
            update(mMemberEntity);
        }

        return mMemberEntity;
    }

    private MMemberEntity update(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }

    public MMemberEntity save(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }

    public void delete(Integer id) {
        MMemberEntity mMemberEntity = find(id);
        mMemberEntity.setEnable(false);
        delete(mMemberEntity);
    }

    public void delete(MMemberEntity mMemberEntity) {
        save(mMemberEntity);
    }


    public MMemberEntity find(Integer id) {
        return memberRepository.getOne(id);
    }

    public SimplePage<MemberVO> list(MemberQueryRequestQueryModel memberQueryRequestModel) {
        Criteria<MMemberEntity> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("cardNum", memberQueryRequestModel.getCardNum(), true));
        criteria.add(Restrictions.eq("memberType", memberQueryRequestModel.getMemberType(), true));
        criteria.add(Restrictions.eq("companyId", memberQueryRequestModel.getCompanyId(), true));
        criteria.add(Restrictions.eq("hrCode", memberQueryRequestModel.getHrCode(), true));
        if (!StringUtils.isEmpty(memberQueryRequestModel.getPaperNum())) {
            //身份证号是加密的
            criteria.add(Restrictions.eq("paperNum", new AES().encrypt(memberQueryRequestModel.getPaperNum()), true));
        }
        if (!StringUtils.isEmpty(memberQueryRequestModel.getCellPhone())) {
            //身份证号是加密的
            criteria.add(Restrictions.eq("cellPhone", new AES().encrypt(memberQueryRequestModel.getCellPhone()), true));
        }
        criteria.add(Restrictions.eq("administrativeLevel", memberQueryRequestModel.getAdministrativeLevel(), true));
        criteria.add(Restrictions.eq("position", memberQueryRequestModel.getPosition(), true));
        criteria.add(Restrictions.eq("isEnable", memberQueryRequestModel.isEnable(), true));
        if (memberQueryRequestModel.isVip() != null) {
            if (memberQueryRequestModel.isVip()) {
                criteria.add(Restrictions.eq("memberClass", "3", true));
            } else {
                criteria.add(Restrictions.ne("memberClass", "3", true));
            }
        }
        if (!StringUtils.isEmpty(memberQueryRequestModel.getRealName())) {
            if (memberQueryRequestModel.isFuzzy()) {
                criteria.add(Restrictions.eq("realName", "%" + memberQueryRequestModel.getRealName() + "%", true));
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

    private MemberVO parseMemberVO(MMemberEntity mMemberEntity) {
        MemberVO memberVO = new MemberVO();
        BeanUtil.copyProperties(mMemberEntity, memberVO);
        memberVO.setMemberTypeValue(dictCache.findByGroupId(7).get(memberVO.getMemberType()));
        memberVO.setCompanyIdValue(companyManager.findName(memberVO.getCompanyId()));
        memberVO.setCellPhone(CommonUtil.aesDecode(memberVO.getCellPhone()));
        memberVO.setPositionValue(dictCache.findByGroupId(49).get(memberVO.getPosition()));
        memberVO.setAdministrativeLevelValue(dictCache.findByGroupId(31).get(memberVO.getAdministrativeLevel()));
        return memberVO;
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
