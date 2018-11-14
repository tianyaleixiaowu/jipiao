package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyTravelLevelManager;
import com.tianyalei.jipiao.core.model.MCompanyTravelLevelEntity;
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
@RequestMapping("companyTravelLevel")
public class CompanyTravelLevelController {
    @Resource
    private CompanyTravelLevelManager companyTravelLevelManager;

    @RequestMapping("/list")
    public BaseData queryByCompanyId(Integer companyId, int page, int size) {
        return ResultGenerator.genSuccessResult(companyTravelLevelManager.findByCompanyId(companyId, page, size));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyTravelLevelEntity entity) {
        return ResultGenerator.genSuccessResult(companyTravelLevelManager.add(entity));
    }
}
