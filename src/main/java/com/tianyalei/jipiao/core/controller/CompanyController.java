package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyManager;
import com.tianyalei.jipiao.core.request.CompanyAddRequestModel;
import com.tianyalei.jipiao.core.request.CompanyQueryRequestModel;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 公司
 * @author wuweifeng wrote on 2018/11/7.
 */
@RestController
@RequestMapping("company")
public class CompanyController {
    @Resource
    private CompanyManager companyManager;

    @RequestMapping("list")
    public BaseData find(CompanyQueryRequestModel requestModel) {
         return ResultGenerator.genSuccessResult(companyManager.list(requestModel));
    }

    @RequestMapping("add")
    public BaseData find(CompanyAddRequestModel requestModel) {
        companyManager.addOrUpdate(requestModel, true);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("update")
    public BaseData update(CompanyAddRequestModel requestModel) {
        companyManager.addOrUpdate(requestModel, false);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/delete/{id}")
    public BaseData update(@PathVariable Integer id) {
        companyManager.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
