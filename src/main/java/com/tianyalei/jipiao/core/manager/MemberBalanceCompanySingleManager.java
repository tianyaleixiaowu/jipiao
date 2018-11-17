package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.core.repository.MemberBalanceCompanyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberBalanceCompanySingleManager {
    @Resource
    private MemberBalanceCompanyRepository memberBalanceCompanyRepository;

    public MMemberBalanceCompanyEntity add(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        return memberBalanceCompanyRepository.save(mMemberBalanceCompanyEntity);
    }

    public MMemberBalanceCompanyEntity update(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        return memberBalanceCompanyRepository.save(mMemberBalanceCompanyEntity);
    }

}
