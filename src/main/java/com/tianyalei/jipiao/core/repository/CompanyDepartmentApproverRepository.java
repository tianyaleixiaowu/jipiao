package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyDepartmentApproverRepository extends JpaRepository<MCompanyDepartmentApproverEntity, Integer>,
        JpaSpecificationExecutor<MCompanyDepartmentApproverEntity> {
      List<MCompanyDepartmentApproverEntity> findByDepartmentId(Integer departmentId);
}
