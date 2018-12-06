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
    public BaseData queryByCompanyId(Integer companyId, Integer page, Integer size, Boolean city) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }

        //如果需要city
        if (city == null) {
            city = false;
        }

        return ResultGenerator.genSuccessResult(companyTravelLevelManager.findByCompanyId(companyId, page, size, city));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyTravelLevelEntity entity) {
        MCompanyTravelLevelEntity entity1 = companyTravelLevelManager.add(entity);
        if (entity1 == null) {
            return ResultGenerator.genFailResult("不能添加重复数据或空数据");
        }
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/enable")
    public BaseData update(Integer id, Boolean enable) {
        return ResultGenerator.genSuccessResult(companyTravelLevelManager.enable(id, enable));
    }
}
