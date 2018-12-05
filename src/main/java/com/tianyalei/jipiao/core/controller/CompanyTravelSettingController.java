package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyTravelSettingManager;
import com.tianyalei.jipiao.core.request.CompanyTravelSettingRequestModel;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestBody;
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
    public BaseData add(@RequestBody CompanyTravelSettingRequestModel model) {
        companyTravelSettingManager.addOrUpdate(model, true);
        return ResultGenerator.genSuccessResult("添加成功");
    }

    @RequestMapping("/query")
    public BaseData queryByTravelLevelId(Integer travelLevelId) {
        return ResultGenerator.genSuccessResult(companyTravelSettingManager.findVoByTravelLevelId(travelLevelId));
    }

    @RequestMapping("/company")
    public BaseData queryByCompanyId(Integer companyId) {
        return ResultGenerator.genSuccessResult(companyTravelSettingManager.findVoByTravelLevelId(companyId));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(@RequestBody CompanyTravelSettingRequestModel model) {
        companyTravelSettingManager.addOrUpdate(model, false);
        return ResultGenerator.genSuccessResult("更新成功");
    }
}
