package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MemberCardNumManager;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
@RestController
@RequestMapping("memberCardNum")
public class MemberCardNumController {
    @Resource
    private MemberCardNumManager memberCardNumManager;

    /**
     * 获取第一条cardNum
     */
    @RequestMapping("/first")
    public BaseData findCardNum() {
        return ResultGenerator.genSuccessResult(memberCardNumManager.findFirstCardNum());
    }
}
