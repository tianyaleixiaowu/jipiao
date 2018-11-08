package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyTravelSettingHotelManager;
import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelEntity;
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
@RequestMapping("companyTravelSettingHotel")
public class CompanyTravelSettingHotelController {
    @Resource
    private CompanyTravelSettingHotelManager companyTravelSettingHotelManager;

    @RequestMapping("/query")
    public BaseData queryByTravelLevelId(Integer travelLevelId) {
        return ResultGenerator.genSuccessResult(companyTravelSettingHotelManager.findByTravelLevelId(travelLevelId));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyTravelSettingHotelEntity entity) {
        return ResultGenerator.genSuccessResult(companyTravelSettingHotelManager.add(entity));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(MCompanyTravelSettingHotelEntity entity) {
        return ResultGenerator.genSuccessResult(companyTravelSettingHotelManager.update(entity));
    }
}
