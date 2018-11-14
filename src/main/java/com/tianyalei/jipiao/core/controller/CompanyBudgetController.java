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
    public BaseData query(Integer companyId, int page, int size) {
        return ResultGenerator.genSuccessResult(companyBudgetManager.findByCompanyId(companyId, page, size));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(CompanyBudgetAddRequestModel model) {
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
