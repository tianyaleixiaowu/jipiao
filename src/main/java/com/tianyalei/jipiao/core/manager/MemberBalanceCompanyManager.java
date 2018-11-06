package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.core.repository.MemberBalanceCompanyRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.util.CommonUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class MemberBalanceCompanyManager {
    @Resource
    private MemberBalanceCompanyRepository memberBalanceCompanyRepository;
    @Resource
    private CompanyManager companyManager;

    public MMemberBalanceCompanyEntity add(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        return memberBalanceCompanyRepository.save(mMemberBalanceCompanyEntity);
    }

    public void parse(MemberAddRequestModel memberAddRequestModel) {
        MMemberBalanceCompanyEntity entity = new MMemberBalanceCompanyEntity();
        entity.setCardNum(CommonUtil.aesEncode(memberAddRequestModel.getCardNum()));
        entity.setCompanyId(memberAddRequestModel.getCompanyId());
        entity.setCompanyName(companyManager.findName(memberAddRequestModel.getCompanyId()));
        entity.setEnable(true);
        entity.setTravelLevelId(memberAddRequestModel.getTravelLevelId());
        add(entity);
    }


    public MMemberBalanceCompanyEntity update(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        return memberBalanceCompanyRepository.save(mMemberBalanceCompanyEntity);
    }

    public void delete(Integer id) {
        memberBalanceCompanyRepository.deleteById(id);
    }

    public MMemberBalanceCompanyEntity find(Integer id) {
        return memberBalanceCompanyRepository.getOne(id);
    }

    public SimplePage<MMemberBalanceCompanyEntity> list(String cardNum, Pageable pageable) {
        Page<MMemberBalanceCompanyEntity> page = memberBalanceCompanyRepository
                .findByCardNum(cardNum, pageable);
        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
    }
}
