package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyDepartmentManager;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("companyDepartment")
public class CompanyDepartmentController {
    @Resource
    private CompanyDepartmentManager companyDepartmentManager;

    @RequestMapping
    public BaseData queryByCompanyId(int companyId) {
        return ResultGenerator.genSuccessResult(companyDepartmentManager.findByCompanyId(companyId));
    }
}
