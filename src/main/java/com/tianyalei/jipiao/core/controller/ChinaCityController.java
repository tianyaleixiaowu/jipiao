package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.ChinaCityManager;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
@RestController
@RequestMapping("/chinaCity")
public class ChinaCityController {
    @Resource
    private ChinaCityManager chinaCityManager;

    @RequestMapping
    public BaseData list() {
        return ResultGenerator.genSuccessResult(chinaCityManager.findAll());
    }
}
