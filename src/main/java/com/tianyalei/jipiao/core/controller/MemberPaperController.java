package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MemberPaperManager;
import com.tianyalei.jipiao.core.model.MMemberPaperEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * 会员证件
 * @author Bai
 * @date 2019/01/04 11:40
 */
@RestController
@RequestMapping("/mMemberPaper")
public class MemberPaperController {

    @Resource
    private MemberPaperManager memberPaperManager;
    /**
     * 动态列表查询
     * @param entity 动态参数
     * @param page 当前页
     * @param size 每页显示条数
     * @param ord 排序字段 默认为id
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseData findList(MMemberPaperEntity entity,
                             @RequestParam(value = "page",defaultValue = "0") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             @RequestParam(value = "size",defaultValue = "id") String ord){
        return ResultGenerator.genSuccessResult(memberPaperManager.list(entity, page, size,ord));
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(memberPaperManager.one(id));
    }

    /**
     * 新增
     * @param entity 实体
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseData add(@RequestBody MMemberPaperEntity entity) {
        return ResultGenerator.genSuccessResult(memberPaperManager.add(entity));
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseData update(@RequestBody MMemberPaperEntity entity) {
        return ResultGenerator.genSuccessResult(memberPaperManager.update(entity));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public BaseData update(@PathVariable Integer id) {
        try {
            memberPaperManager.updateIsEnable(id);
        }catch (Exception e){
            return ResultGenerator.genFailResult("删除数据失败");
        }
        return ResultGenerator.genSuccessResult();
    }
}
