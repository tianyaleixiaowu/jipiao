package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyEntity;
import com.tianyalei.jipiao.core.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanySingleManager {
    @Resource
    private CompanyRepository companyRepository;

    public MCompanyEntity add(MCompanyEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public MCompanyEntity update(MCompanyEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    private MCompanyEntity save(MCompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }
}
