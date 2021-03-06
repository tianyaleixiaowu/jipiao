package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyDepartmentApproverManager;
import com.tianyalei.jipiao.core.model.MCompanyDepartmentApproverEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 单位审批人
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("companyDepartmentApprover")
public class CompanyDepartmentApproverController {
    @Resource
    private CompanyDepartmentApproverManager companyDepartmentApproverManager;

    @RequestMapping("/list")
    public BaseData queryByDeptId(Integer deptId, Integer companyId, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        if (deptId != null) {
            return ResultGenerator.genSuccessResult(companyDepartmentApproverManager.findByDeptId(deptId, page, size));
        }
        if (companyId != null) {
            return ResultGenerator.genSuccessResult(companyDepartmentApproverManager.findByCompanyId(companyId, page, size));
        }
        return ResultGenerator.genFailResult("部门id和公司id不能都为空");
    }

    @RequestMapping("/{id}")
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(companyDepartmentApproverManager.find(id));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyDepartmentApproverEntity entity) {
        return companyDepartmentApproverManager.add(entity);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(MCompanyDepartmentApproverEntity entity) {
        BaseData validate = companyDepartmentApproverManager.validate(entity);
        if(validate != null)
            return validate;
        return ResultGenerator.genSuccessResult(companyDepartmentApproverManager.update(entity));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public BaseData delete(Integer id) {
        companyDepartmentApproverManager.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
