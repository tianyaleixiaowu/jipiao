package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyBudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyBudgetRepository extends JpaRepository<MCompanyBudgetEntity, Integer>,
        JpaSpecificationExecutor<MCompanyBudgetEntity> {
    List<MCompanyBudgetEntity> findByCompanyId(Integer companyId);
}
