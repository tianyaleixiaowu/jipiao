package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MemberManager;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.core.request.MemberQueryRequestQueryModel;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 会员
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("member")
public class MemberController {
    @Resource
    private MemberManager memberManager;

    @RequestMapping("/list")
    public BaseData list(MemberQueryRequestQueryModel memberQueryRequestModel) {
        return ResultGenerator.genSuccessResult(memberManager.list(memberQueryRequestModel));
    }

    @RequestMapping("/{cardNum}")
    public BaseData one(@PathVariable String cardNum) {
        return ResultGenerator.genSuccessResult(memberManager.findOne(cardNum));
    }

    @RequestMapping("/update")
    public BaseData update(@Valid MemberAddRequestModel mMemberEntity, BindingResult bindingResult) {
        return memberManager.addOrUpdate(mMemberEntity, true);
    }

    @RequestMapping("/add")
    public BaseData save(@Valid MemberAddRequestModel mMemberEntity, BindingResult bindingResult) {
        if (CollectionUtil.isNotEmpty(bindingResult.getAllErrors())) {
            return ResultGenerator.genFailResult(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        return memberManager.addOrUpdate(mMemberEntity, true);
    }

    @RequestMapping("/delete/{cardNum}")
    public BaseData delete(@PathVariable String cardNum) {
        memberManager.delete(cardNum);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
