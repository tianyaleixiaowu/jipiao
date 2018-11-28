package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyApproverManager;
import com.tianyalei.jipiao.core.model.MCompanyApproverEntity;
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
@RequestMapping("companyApprover")
public class CompanyApproverController {
    @Resource
    private CompanyApproverManager companyApproverManager;

    @RequestMapping("/list")
    public BaseData queryByCompanyId(Integer companyId, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        return ResultGenerator.genSuccessResult(companyApproverManager.findByCompanyId(companyId, page, size));
    }

    @RequestMapping("/{id}")
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(companyApproverManager.find(id));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyApproverEntity entity) {
        MCompanyApproverEntity entity1 = companyApproverManager.add(entity);
        if (entity1 == null) {
            return ResultGenerator.genFailResult("重复的审批人");
        }
        return ResultGenerator.genSuccessResult(entity1);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(MCompanyApproverEntity entity) {
        MCompanyApproverEntity entity1 = companyApproverManager.update(entity);
        if (entity1 == null) {
            return ResultGenerator.genFailResult("重复的审批人");
        }
        return ResultGenerator.genSuccessResult(entity1);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public BaseData delete(Integer id) {
        companyApproverManager.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
