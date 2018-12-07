package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentApproverEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyDepartmentApproverRepository extends JpaRepository<MCompanyDepartmentApproverEntity, Integer>,
        JpaSpecificationExecutor<MCompanyDepartmentApproverEntity> {
      Page<MCompanyDepartmentApproverEntity> findByDepartmentId(Integer departmentId, Pageable pageable);

      Page<MCompanyDepartmentApproverEntity> findByCompanyId(Integer companyId, Pageable pageable);

      MCompanyDepartmentApproverEntity findFirstByDepartmentIdAndCardNum(Integer deptId, String cardNum);

}
