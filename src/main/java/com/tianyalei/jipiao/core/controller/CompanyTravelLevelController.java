package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyTravelLevelManager;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("companyTravelLevel")
public class CompanyTravelLevelController {
    @Resource
    private CompanyTravelLevelManager companyTravelLevelManager;

    @RequestMapping
    public BaseData queryByCompanyId(int companyId) {
        return ResultGenerator.genSuccessResult(companyTravelLevelManager.findByCompanyId(companyId));
    }
}
