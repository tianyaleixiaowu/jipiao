package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyDepartmentManager;
import com.tianyalei.jipiao.core.model.MCompanyDepartmentEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 部门管理
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("companyDepartment")
public class CompanyDepartmentController {
    @Resource
    private CompanyDepartmentManager companyDepartmentManager;


    @RequestMapping("/list")
    public BaseData queryByCompanyId(Integer companyId) {
        return ResultGenerator.genSuccessResult(companyDepartmentManager.findByCompanyId(companyId));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyDepartmentEntity entity) {
        return ResultGenerator.genSuccessResult(companyDepartmentManager.add(entity));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(MCompanyDepartmentEntity entity) {
        return ResultGenerator.genSuccessResult(companyDepartmentManager.update(entity));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public BaseData delete(Integer id) {
        companyDepartmentManager.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
