package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyApproverManager;
import com.tianyalei.jipiao.core.model.MCompanyApproverEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
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
    public BaseData queryByCompanyId(Integer companyId, int page, int size) {
        return ResultGenerator.genSuccessResult(companyApproverManager.findByCompanyId(companyId, page, size));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public BaseData add(MCompanyApproverEntity entity) {
        return ResultGenerator.genSuccessResult(companyApproverManager.add(entity));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public BaseData update(MCompanyApproverEntity entity) {
        return ResultGenerator.genSuccessResult(companyApproverManager.update(entity));
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
