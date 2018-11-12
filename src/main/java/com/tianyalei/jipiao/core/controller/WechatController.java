package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.request.Wechat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuweifeng wrote on 2018/11/12.
 */
@RestController
@RequestMapping("wechat")
public class WechatController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("")
    public void wechat(@RequestBody Wechat wechat) {
        logger.info(wechat.toString());
    }
}

