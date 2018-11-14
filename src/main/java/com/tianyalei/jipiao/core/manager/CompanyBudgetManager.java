package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyBudgetEntity;
import com.tianyalei.jipiao.core.repository.CompanyBudgetRepository;
import com.tianyalei.jipiao.global.bean.SimplePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyBudgetManager {
    @Resource
    private CompanyBudgetRepository companyBudgetRepository;

    public MCompanyBudgetEntity add(MCompanyBudgetEntity entity) {
        return save(entity);
    }

    public MCompanyBudgetEntity update(MCompanyBudgetEntity entity) {
        return save(entity);
    }

    public void delete(Integer id) {
        companyBudgetRepository.deleteById(id);
    }

    private MCompanyBudgetEntity save(MCompanyBudgetEntity mCompanyBudgetEntity) {
        return companyBudgetRepository.save(mCompanyBudgetEntity);
    }

    public MCompanyBudgetEntity find(Integer id) {
        return companyBudgetRepository.getOne(id);
    }

    public SimplePage<MCompanyBudgetEntity> findByCompanyId(Integer companyId, int pp, int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyBudgetEntity> page = companyBudgetRepository.findByCompanyId(companyId,
                pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent());
    }
}
