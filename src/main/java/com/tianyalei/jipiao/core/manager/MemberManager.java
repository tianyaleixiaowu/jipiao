package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberEntity;
import com.tianyalei.jipiao.core.repository.MemberRepository;
import com.tianyalei.jipiao.core.request.MemberQueryRequestModel;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
import com.tianyalei.jipiao.global.specify.Criteria;
import com.tianyalei.jipiao.global.specify.Restrictions;
import com.xiaoleilu.hutool.crypto.symmetric.AES;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

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
    private DictCache dictCache;

    public MMemberEntity add(MMemberEntity mMemberEntity) {
        //删除cardNum的数据
        memberCardNumManager.deleteByCardNum(mMemberEntity.getCardNum());
        return null;
        //return memberRepository.save(mMemberEntity);
    }

    public MMemberEntity update(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }

    public void delete(Integer id) {
        memberRepository.deleteById(id);
    }

    public MMemberEntity find(Integer id) {
        return memberRepository.getOne(id);
    }

    public SimplePage<MMemberEntity> list(MemberQueryRequestModel memberQueryRequestModel) {
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
                ecContactEntities.getContent());
    }

}
