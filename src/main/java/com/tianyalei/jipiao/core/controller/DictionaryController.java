package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.DictionaryManager;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {
    @Resource
    private DictionaryManager dictionaryManager;

    @RequestMapping
    public BaseData queryByGroupId(int groupId) {
        return ResultGenerator.genSuccessResult(dictionaryManager.findByGroupId(groupId));
    }
}
