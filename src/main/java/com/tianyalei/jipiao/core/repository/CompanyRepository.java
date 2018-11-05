package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyRepository extends JpaRepository<MCompanyEntity, Integer>, JpaSpecificationExecutor<MCompanyEntity> {

}
