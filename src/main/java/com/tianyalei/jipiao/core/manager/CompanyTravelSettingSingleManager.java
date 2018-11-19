package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/19.
 */
@Service
public class CompanyTravelSettingSingleManager {
    @Resource
    private CompanyTravelSettingRepository companyTravelSettingRepository;

    public MCompanyTravelSettingEntity add(MCompanyTravelSettingEntity mCompanyTravelSettingEntity) {
       return companyTravelSettingRepository.save(mCompanyTravelSettingEntity);
    }

    public MCompanyTravelSettingEntity update(MCompanyTravelSettingEntity mCompanyTravelSettingEntity) {
        return companyTravelSettingRepository.save(mCompanyTravelSettingEntity);
    }
}
