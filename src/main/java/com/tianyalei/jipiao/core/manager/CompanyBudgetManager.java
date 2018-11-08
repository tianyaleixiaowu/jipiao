package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyBudgetEntity;
import com.tianyalei.jipiao.core.repository.CompanyBudgetRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<MCompanyBudgetEntity> findByCompanyId(Integer companyId) {
        return companyBudgetRepository.findByCompanyId(companyId);
    }
}
