package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyApproverRepository extends JpaRepository<MCompanyApproverEntity, Integer>,
        JpaSpecificationExecutor<MCompanyApproverEntity> {
    List<MCompanyApproverEntity> findByCompanyId(Integer companyId);
}
