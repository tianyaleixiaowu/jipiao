package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MemberCardNumManager;
import com.tianyalei.jipiao.core.manager.MemberManager;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.core.request.MemberQueryRequestQueryModel;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 会员
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("member")
public class MemberController {
    @Resource
    private MemberManager memberManager;
    @Resource
    private MemberCardNumManager memberCardNumManager;

    /**
     * 获取第一条cardNum
     */
    @RequestMapping("/cardNum")
    public BaseData findCardNum() {
        return ResultGenerator.genSuccessResult(memberCardNumManager.findFirstCardNum());
    }

    @RequestMapping("/list")
    public BaseData list(MemberQueryRequestQueryModel memberQueryRequestModel) {
        return ResultGenerator.genSuccessResult(memberManager.list(memberQueryRequestModel));
    }

    @RequestMapping("/{id}")
    public BaseData one(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(memberManager.find(id));
    }

    @RequestMapping("/update")
    public BaseData update(MemberAddRequestModel mMemberEntity) {
        return ResultGenerator.genSuccessResult(memberManager.addOrUpdate(mMemberEntity, false));
    }

    @RequestMapping("/add")
    public BaseData save(MemberAddRequestModel mMemberEntity) {
        return ResultGenerator.genSuccessResult(memberManager.addOrUpdate(mMemberEntity, true));
    }

    @RequestMapping("/delete/{id}")
    public BaseData delete(@PathVariable Integer id) {
        memberManager.delete(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
