package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.CompanyManager;
import com.tianyalei.jipiao.core.model.MCompanyEntity;
import com.tianyalei.jipiao.core.request.CompanyAddRequestModel;
import com.tianyalei.jipiao.core.request.CompanyQueryRequestModel;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.util.StringUtils;
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

    @RequestMapping("/{id}")
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(companyManager.find(id));
    }

    @RequestMapping("add")
    public BaseData add(CompanyAddRequestModel requestModel) {
        if (requestModel.getServerCost().doubleValue() > 999) {
            return ResultGenerator.genFailResult("服务费值太大");
        }
        /*if(requestModel.getParentId() == null){
            return ResultGenerator.genFailResult("请填写上级单位");
        }*/
        //null添加顶级
        if(StringUtils.isEmpty(requestModel.getParentId())){
            requestModel.setParentId("0");
        }
        MCompanyEntity entity = companyManager.addOrUpdate(requestModel, true);
        if (entity == null) {
            return ResultGenerator.genFailResult("公司名已存在");
        }
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("update")
    public BaseData update(CompanyAddRequestModel requestModel) {
        if (requestModel.getServerCost().doubleValue() > 999) {
            return ResultGenerator.genFailResult("服务费值太大");
        }
        companyManager.addOrUpdate(requestModel, false);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/delete/{id}")
    public BaseData update(@PathVariable Integer id) {
        companyManager.delete(id);
        return ResultGenerator.genSuccessResult();
    }
}
