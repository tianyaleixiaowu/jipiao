package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyTravelSettingManager;
import com.tianyalei.jipiao.core.model.MCompanyTravelSettingEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 差旅等级
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("companyTravelSetting")
public class CompanyTravelSettingController {
    @Resource
    private CompanyTravelSettingManager companyTravelSettingManager;

    @RequestMapping("/add")
    public BaseData add(MCompanyTravelSettingEntity entity) {
        return ResultGenerator.genSuccessResult(companyTravelSettingManager.add(entity));
    }

    @RequestMapping("/query")
    public BaseData queryByTravelLevelId(Integer travelLevelId) {
        return ResultGenerator.genSuccessResult(companyTravelSettingManager.findByTravelLevelId(travelLevelId));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(MCompanyTravelSettingEntity entity) {
        return ResultGenerator.genSuccessResult(companyTravelSettingManager.update(entity));
    }
}
