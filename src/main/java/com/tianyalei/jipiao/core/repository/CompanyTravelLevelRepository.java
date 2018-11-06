package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyTravelLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyTravelLevelRepository extends JpaRepository<MCompanyTravelLevelEntity, Integer>,
        JpaSpecificationExecutor<MCompanyTravelLevelEntity> {
    List<MCompanyTravelLevelEntity> findByCompanyId(Integer companyId);
}
