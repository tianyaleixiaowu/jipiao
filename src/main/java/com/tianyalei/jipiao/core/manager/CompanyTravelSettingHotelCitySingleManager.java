package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelCityEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingHotelCityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 差旅等级设置
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelSettingHotelCitySingleManager {
    @Resource
    private CompanyTravelSettingHotelCityRepository companyTravelSettingHotelCityRepository;


    public MCompanyTravelSettingHotelCityEntity add(MCompanyTravelSettingHotelCityEntity companyTravelSettingHotelCityEntity) {
        return companyTravelSettingHotelCityRepository.save(companyTravelSettingHotelCityEntity);
    }

}
