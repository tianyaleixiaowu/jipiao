package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 差旅等级设置
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelSettingManager {
    @Resource
    private CompanyTravelSettingRepository companyTravelSettingRepository;


    public MCompanyTravelSettingEntity add(MCompanyTravelSettingEntity companyTravelSettingEntity) {
        return companyTravelSettingRepository.save(companyTravelSettingEntity);
    }

    public MCompanyTravelSettingEntity update(MCompanyTravelSettingEntity companyTravelSettingEntity) {
        return companyTravelSettingRepository.save(companyTravelSettingEntity);
    }

    public MCompanyTravelSettingEntity find(Integer id) {
        return companyTravelSettingRepository.getOne(id);
    }

    public MCompanyTravelSettingEntity findByTravelLevelId(Integer travelLevelId) {
        return companyTravelSettingRepository.findFirstByTravelLevelId(travelLevelId);
    }

}
