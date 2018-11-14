package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyDepartmentRepository extends JpaRepository<MCompanyDepartmentEntity, Integer>,
        JpaSpecificationExecutor<MCompanyDepartmentEntity> {
      Page<MCompanyDepartmentEntity> findByCompanyIdAndIsEnableTrue(Integer companyId, Pageable pageable);
}
