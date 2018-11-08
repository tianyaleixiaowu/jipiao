package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyTravelSettingHotelRepository extends JpaRepository<MCompanyTravelSettingHotelEntity, Integer> {
    List<MCompanyTravelSettingHotelEntity> findByTravelLevelId(Integer travelLevelId);
}
