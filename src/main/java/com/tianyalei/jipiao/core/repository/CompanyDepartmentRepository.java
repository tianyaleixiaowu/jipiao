package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyDepartmentRepository extends JpaRepository<MCompanyDepartmentEntity, Integer>,
        JpaSpecificationExecutor<MCompanyDepartmentEntity> {
      List<MCompanyDepartmentEntity> findByCompanyIdAndIsEnableTrue(Integer companyId);
}
