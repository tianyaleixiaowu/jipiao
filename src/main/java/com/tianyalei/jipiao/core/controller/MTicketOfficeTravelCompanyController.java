package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MTicketOfficeTravelCompanyManager;
import com.tianyalei.jipiao.core.model.MTicketOfficeTravelCompanyEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* 差旅单位表
* @author Bai
* @date 2019/01/08 11:55
*/
@RestController
@RequestMapping("/mTicketOfficeTravelCompany")
public class MTicketOfficeTravelCompanyController {

    @Resource
    private MTicketOfficeTravelCompanyManager mTicketOfficeTravelCompanyManager;

    /**
    * 动态列表查询
    * @param entity 动态参数
    * @param page 当前页
    * @param size 每页显示条数
    * @param ord 排序字段 默认为id
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseData findList(MTicketOfficeTravelCompanyEntity entity,
                                @RequestParam(value = "page",defaultValue = "0") Integer page,
                                @RequestParam(value = "size",defaultValue = "10") Integer size,
                                @RequestParam(value = "size",defaultValue = "id") String ord){
        return ResultGenerator.genSuccessResult(mTicketOfficeTravelCompanyManager.list(entity, page, size,ord));
    }

    /**
    * 详情
    * @param id
    * @return
    */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(mTicketOfficeTravelCompanyManager.one(id));
    }

    /**
    * 新增
    * @param entity 实体
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseData add(@RequestBody MTicketOfficeTravelCompanyEntity entity) {
        return ResultGenerator.genSuccessResult(mTicketOfficeTravelCompanyManager.add(entity));
    }

    /**
    * 修改
    * @param entity
    * @return
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseData update(@RequestBody MTicketOfficeTravelCompanyEntity entity) {
        return ResultGenerator.genSuccessResult(mTicketOfficeTravelCompanyManager.update(entity));
    }

    /**
    * 删除
    * @param id
    * @return
    */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public BaseData update(@PathVariable Integer id) {
        try {
            mTicketOfficeTravelCompanyManager.updateIsEnable(id);
        }catch (Exception e){
            return ResultGenerator.genFailResult("删除数据失败");
        }
        return ResultGenerator.genSuccessResult();
    }
}