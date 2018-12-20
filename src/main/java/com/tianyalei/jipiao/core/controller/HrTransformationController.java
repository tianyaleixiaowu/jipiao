package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.HrTransformationManager;
import com.tianyalei.jipiao.core.model.MHrOrganizationEntity;
import com.tianyalei.jipiao.core.model.TFEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.bean.SimplePage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * hr转换
 */
@RestController
@RequestMapping("/hrTransformation")
public class HrTransformationController {

    @Resource
    private HrTransformationManager hrTransformationManager;

    /**
     * 分页查询
     * @param entity 高级查询表对象
     * @param page 当前页
     * @param size 每页条数
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public BaseData findPage(MHrOrganizationEntity entity, Integer page, Integer size) {
        if (page == null)
            page = 0;
        if (size == null || size == 0)
            size = 10;

        SimplePage simplePage = hrTransformationManager.findAll(entity,page,size);
        return ResultGenerator.genSuccessResult(simplePage);
    }

    /**
     * 树查询
     * @param orgId 等级树id
     * @return
     */
    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    public BaseData findTree(String orgId){

       try{
           if(orgId == null || orgId.equals("")){
               return ResultGenerator.genSuccessResult(hrTransformationManager.findFatherTree());
           }
           else{
               return ResultGenerator.genSuccessResult(hrTransformationManager.findTree(orgId));
           }
       }catch (Exception e){
           return ResultGenerator.genFailResult("批量转换单位查询失败");
       }
    }

    /**
     * 单位转换
     *      两种情况，1.新增上级，2，根据上级新增下级
     * @param entity 表单接收
     * @return
     */
    @RequestMapping(value = "/tFCompany",method = RequestMethod.POST)
    public BaseData add(@RequestBody TFEntity entity){
        return ResultGenerator.genSuccessResult(hrTransformationManager.add(entity));
    }

    /**
     * 批量转换，默认第一级所有数据
     * @param  orgId id
     * @return
     */
    @RequestMapping(value = "/tfCompanyList",method = RequestMethod.GET)
    public BaseData tfCompanyList(String orgId){
        try{
            if(orgId == null || orgId.equals("")){
                return ResultGenerator.genSuccessResult(hrTransformationManager.findFatherTree());
            }else{
                return ResultGenerator.genSuccessResult(hrTransformationManager.findTFCompanyList(orgId));
            }
        }catch (Exception e){
            return ResultGenerator.genFailResult("查询失败");
        }
    }
}
