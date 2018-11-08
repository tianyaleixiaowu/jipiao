package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyTravelSettingRepository extends JpaRepository<MCompanyTravelSettingEntity, Integer>,
        JpaSpecificationExecutor<MCompanyTravelSettingEntity> {
    List<MCompanyTravelSettingEntity> findByTravelLevelId(Integer travelLevelId);

    MCompanyTravelSettingEntity findFirstByTravelLevelId(Integer travelLevelId);
}
