package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyBudgetManager;
import com.tianyalei.jipiao.core.request.CompanyBudgetAddRequestModel;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/8.
 */
@RestController
@RequestMapping("/companyBudget")
public class CompanyBudgetController {
    @Resource
    private CompanyBudgetManager companyBudgetManager;

    @RequestMapping("list")
    public BaseData query(Integer companyId, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        return ResultGenerator.genSuccessResult(companyBudgetManager.findByCompanyId(companyId, page, size));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(CompanyBudgetAddRequestModel model) {
        if(model.getTotalCost().compareTo(model.getSurplusCost()) == -1){
            return ResultGenerator.genFailResult("剩余预算不能大于总预算");
        }
        return ResultGenerator.genSuccessResult(companyBudgetManager.add(model.toEntity()));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(CompanyBudgetAddRequestModel model) {
        return ResultGenerator.genSuccessResult(companyBudgetManager.update(model.toEntity()));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public BaseData delete(Integer id) {
        companyBudgetManager.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
