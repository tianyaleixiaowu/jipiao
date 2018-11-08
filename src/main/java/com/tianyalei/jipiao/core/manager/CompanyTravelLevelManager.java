package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelLevelEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelLevelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelLevelManager {
    @Resource
    private CompanyTravelLevelRepository companyTravelLevelRepository;
    @Resource
    private CompanyTravelSettingHotelCityManager companyTravelSettingHotelCityManager;


    public MCompanyTravelLevelEntity add(MCompanyTravelLevelEntity mCompanyEntity) {
        MCompanyTravelLevelEntity entity = companyTravelLevelRepository.save(mCompanyEntity);
        //将city的数据，插入到M_CompanyTravelSettingHotelCity表
        if ("2".equals(mCompanyEntity.getLevelType())) {
            String cities = mCompanyEntity.getCities();
            companyTravelSettingHotelCityManager.add(entity.getId(), cities);
        }

        return entity;
    }

    public MCompanyTravelLevelEntity find(Integer id) {
        return companyTravelLevelRepository.getOne(id);
    }

    public List<MCompanyTravelLevelEntity> findByCompanyId(Integer companyId) {
        return companyTravelLevelRepository.findByCompanyId(companyId);
    }
}
