package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingHotelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 差旅等级设置
 *
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelSettingHotelManager {
    @Resource
    private CompanyTravelSettingHotelRepository companyTravelSettingHotelRepository;


    public MCompanyTravelSettingHotelEntity add(MCompanyTravelSettingHotelEntity companyTravelSettingHotelEntity) {
        MCompanyTravelSettingHotelEntity entity = companyTravelSettingHotelRepository.findByTravelLevelIdAndCityLevelId
                (companyTravelSettingHotelEntity
                                .getTravelLevelId(),
                        companyTravelSettingHotelEntity.getCityLevelId());
        if (entity == null) {
            return companyTravelSettingHotelRepository.save(companyTravelSettingHotelEntity);
        } else {
            return null;
        }

    }

    public MCompanyTravelSettingHotelEntity update(MCompanyTravelSettingHotelEntity companyTravelSettingHotelEntity) {
        return companyTravelSettingHotelRepository.save(companyTravelSettingHotelEntity);
    }

    public void deleteByTravelLevelId(Integer travelLevelId) {
        companyTravelSettingHotelRepository.deleteByTravelLevelId(travelLevelId);
    }

    public MCompanyTravelSettingHotelEntity find(Integer id) {
        return companyTravelSettingHotelRepository.getOne(id);
    }

    public List<MCompanyTravelSettingHotelEntity> findByTravelLevelId(Integer travelLevelId) {
        return companyTravelSettingHotelRepository.findByTravelLevelId(travelLevelId);
    }
}
