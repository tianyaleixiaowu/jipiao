package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.HtCountryManager;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("country")
public class CountryController {
    @Resource
    private HtCountryManager countryManager;

    @RequestMapping
    public BaseData queryByGroupId() {
        return ResultGenerator.genSuccessResult(countryManager.findAll());
    }
}
