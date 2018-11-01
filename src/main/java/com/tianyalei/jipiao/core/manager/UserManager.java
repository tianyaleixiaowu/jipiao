package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.bean.LoginData;
import com.tianyalei.jipiao.core.model.SysUser;
import com.tianyalei.jipiao.core.repository.UserRepository;
import com.tianyalei.jipiao.global.cache.UserCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/4/16.
 */
@Service
public class UserManager {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserCache userCache;

    /**
     * 登录
     */
    public LoginData login(SysUser user) {
        SysUser temp = userRepository.findByAccount(user.getAccount());
        LoginData loginData = new LoginData();

        if (temp == null) {
            loginData.setCode(-1);
            loginData.setMessage("用户不存在");
        } else if (!temp.getPassword().equals(user.getPassword())) {
            loginData.setCode(-2);
            loginData.setMessage("密码错误");
        } else {
            //登录成功
            loginData.setCode(0);
            //保存token
            loginData.setToken(userCache.saveToken(temp.getId()));
        }
        return loginData;
    }


}
