package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyTravelLevelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyTravelLevelRepository extends JpaRepository<MCompanyTravelLevelEntity, Integer>,
        JpaSpecificationExecutor<MCompanyTravelLevelEntity> {
    Page<MCompanyTravelLevelEntity> findByCompanyId(Integer companyId, Pageable pageable);

    List<MCompanyTravelLevelEntity> findByCompanyId(Integer companyId);

    Page<MCompanyTravelLevelEntity> findByCompanyIdAndLevelType(Integer companyId, String levelType, Pageable
            pageable);
}
