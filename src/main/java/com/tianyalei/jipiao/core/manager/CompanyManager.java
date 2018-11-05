package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyEntity;
import com.tianyalei.jipiao.core.repository.CompanyRepository;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.specify.Criteria;
import com.tianyalei.jipiao.global.specify.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyManager {
    @Resource
    private CompanyRepository companyRepository;

    public MCompanyEntity add(MCompanyEntity mCompanyEntity) {
        return companyRepository.save(mCompanyEntity);
    }

    public MCompanyEntity update(MCompanyEntity mCompanyEntity) {
        return companyRepository.save(mCompanyEntity);
    }

    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }

    public MCompanyEntity find(Integer id) {
        return companyRepository.getOne(id);
    }

    public SimplePage<MCompanyEntity> list(Pageable pageable) {
        Criteria<MCompanyEntity> criteria = new Criteria<>();
        criteria.add(Restrictions.eq("state", 1, true));
        Page<MCompanyEntity> ecContactEntities = companyRepository.findAll(criteria, pageable);
        return new SimplePage<>(ecContactEntities.getTotalPages(), ecContactEntities.getTotalElements(), null);
    }

}
