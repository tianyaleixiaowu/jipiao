package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MMemberPassengerManager;
import com.tianyalei.jipiao.core.model.MMemberPassengerEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* 会员（因公出行）常用乘机人表
* @author Bai
* @date 2019/01/07 11:38
*/
@RestController
@RequestMapping("/mMemberPassenger")
public class MMemberPassengerController {

    @Resource
    private MMemberPassengerManager mMemberPassengerManager;

    /**
    * 动态列表查询
    * @param entity 动态参数
    * @param page 当前页
    * @param size 每页显示条数
    * @param ord 排序字段 默认为id
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseData findList(MMemberPassengerEntity entity,
                                @RequestParam(value = "page",defaultValue = "0") Integer page,
                                @RequestParam(value = "size",defaultValue = "10") Integer size,
                                @RequestParam(value = "size",defaultValue = "id") String ord){
        return ResultGenerator.genSuccessResult(mMemberPassengerManager.list(entity, page, size,ord));
    }

    /**
    * 详情
    * @param id
    * @return
    */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(mMemberPassengerManager.one(id));
    }

    /**
    * 新增
    * @param entity 实体
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseData add(@RequestBody MMemberPassengerEntity entity) {
        return ResultGenerator.genSuccessResult(mMemberPassengerManager.add(entity));
    }

    /**
    * 修改
    * @param entity
    * @return
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseData update(@RequestBody MMemberPassengerEntity entity) {
        return ResultGenerator.genSuccessResult(mMemberPassengerManager.update(entity));
    }

    /**
    * 删除
    * @param id
    * @return
    */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public BaseData update(@PathVariable Integer id) {
        try {
            mMemberPassengerManager.updateIsEnable(id);
        }catch (Exception e){
            return ResultGenerator.genFailResult("删除数据失败");
        }
        return ResultGenerator.genSuccessResult();
    }
}