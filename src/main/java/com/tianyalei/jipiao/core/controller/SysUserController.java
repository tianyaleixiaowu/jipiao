package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.SysUserManager;
import com.tianyalei.jipiao.core.model.SysUser;
import com.tianyalei.jipiao.global.bean.BaseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Resource
    private SysUserManager sysUserManager;

    @RequestMapping("login")
    public BaseData login(SysUser sysUser) {
        return sysUserManager.login(sysUser);
    }

    @RequestMapping("menu")
    public BaseData menu(HttpServletRequest request) {
        return sysUserManager.menu(request);
    }
}
