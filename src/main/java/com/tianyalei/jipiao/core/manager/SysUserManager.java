package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.bean.LoginData;
import com.tianyalei.jipiao.core.model.SysUser;
import com.tianyalei.jipiao.core.repository.SysUserRepository;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultCode;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.cache.UserCache;
import com.tianyalei.jipiao.global.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/4/16.
 */
@Service
public class SysUserManager {
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private UserCache userCache;

    /**
     * 登录
     */
    public BaseData login(SysUser user) {
        SysUser temp = sysUserRepository.findByAccount(user.getAccount());
        LoginData loginData = new LoginData();

        if (temp == null) {
            loginData.setCode(-1);
            loginData.setMessage("用户不存在");
            return ResultGenerator.genFailResult(ResultCode.ACCOUNT_ERROR, "账户不存在");
        } else if (!temp.getPassword().equals(CommonUtil.md5(user.getPassword()))) {
            loginData.setCode(-2);
            return ResultGenerator.genFailResult(ResultCode.ACCOUNT_ERROR, "密码错误");
        } else {
            return ResultGenerator.genSuccessResult(userCache.saveToken(temp.getId()));
        }

    }

    public BaseData modifyPassword(Long userId, String oldPassword, String newPassword) {
        if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "旧密码错误");
        }

        SysUser sysUser = sysUserRepository.getOne(userId);

        if(!sysUser.getPassword().equals(CommonUtil.md5(oldPassword))) {
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "旧密码错误");
        }
        sysUser.setPassword(CommonUtil.md5(newPassword));
        sysUserRepository.save(sysUser);

        return ResultGenerator.genSuccessResult("修改成功");
    }


}
