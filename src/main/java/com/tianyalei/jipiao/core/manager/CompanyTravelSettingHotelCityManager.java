package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelCityEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingHotelCityRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 差旅等级设置
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelSettingHotelCityManager {
    @Resource
    private CompanyTravelSettingHotelCityRepository companyTravelSettingHotelCityRepository;
    @Resource
    private ChinaCityManager chinaCityManager;


    public MCompanyTravelSettingHotelCityEntity add(MCompanyTravelSettingHotelCityEntity companyTravelSettingHotelCityEntity) {
        return companyTravelSettingHotelCityRepository.save(companyTravelSettingHotelCityEntity);
    }

    public void add(Integer travelLevelId, String cities) {
        String[] cityArray = cities.split(",");
        for (String cityId : cityArray) {
            if (StringUtils.isEmpty(cityId)) {
                continue;
            }
            MCompanyTravelSettingHotelCityEntity mCompanyTravelSettingHotelEntity = new MCompanyTravelSettingHotelCityEntity();
            mCompanyTravelSettingHotelEntity.setCityLevelId(travelLevelId);
            mCompanyTravelSettingHotelEntity.setCityId(cityId);
            mCompanyTravelSettingHotelEntity.setCityName(chinaCityManager.findNameByCityId(cityId));
            add(mCompanyTravelSettingHotelEntity);
        }
    }


    public MCompanyTravelSettingHotelCityEntity find(Integer id) {
        return companyTravelSettingHotelCityRepository.getOne(id);
    }

}
