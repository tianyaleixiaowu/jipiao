package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MHrDepartmentEntity;
import com.tianyalei.jipiao.core.model.MHrOrganizationEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface HrDepartmentRepository extends JpaRepository<MHrDepartmentEntity, String> {

    List<MHrDepartmentEntity> findByOrgId(String orgId);
}
