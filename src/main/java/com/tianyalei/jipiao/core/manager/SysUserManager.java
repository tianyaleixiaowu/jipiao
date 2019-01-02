package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.bean.LoginData;
import com.tianyalei.jipiao.core.bean.LoginUserBean;
import com.tianyalei.jipiao.core.bean.Menu;
import com.tianyalei.jipiao.core.bean.MenuData;
import com.tianyalei.jipiao.core.model.SysUser;
import com.tianyalei.jipiao.core.repository.SysUserRepository;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultCode;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.cache.UserCache;
import com.tianyalei.jipiao.global.util.FastJsonUtils;
import com.xiaoleilu.hutool.crypto.digest.DigestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuweifeng wrote on 2018/4/16.
 */
@Service
public class SysUserManager {
    @Resource
    private UserCache userCache;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private SysUserRepository sysUserRepository;
    @Value("${login.url}")
    private String loginUrl;

    @PostConstruct
    public void pr() {
        System.err.println(loginUrl);
    }

    private String systemCode = "Member";
    private String Key = "f3b18dffb528d2fbdc61be6aca3f838c";

    Logger logger = LoggerFactory.getLogger(getClass());

    public void save(SysUser sysUser) {
        sysUserRepository.save(sysUser);
    }

    /**
     * 登录
     */
    public BaseData login(SysUser user) {
        String account = user.getAccount();
        String password = user.getPassword();
        String s = "SystemCode=" + systemCode + "&UserName=" + account + "&Password="
                + DigestUtil.md5Hex(password).toUpperCase();
        String sign = DigestUtil.md5Hex(s + "&Key=" + Key).toUpperCase();
        String resultStr = s + "&SignMsg=" + sign;

        logger.info("最终请求的字符串是：" + resultStr);
        logger.info("登录请求的地址loginUrl：" + loginUrl);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("SystemCode", systemCode);
        map.add("UserName", account);
        map.add("Password", DigestUtil.md5Hex(password).toUpperCase());
        map.add("SignMsg", sign);

        try {
            String s1 = restTemplate.postForEntity(loginUrl, map,
                    String.class)
                    .getBody();
            logger.info("返回值：" + s1);
            LoginData loginData = FastJsonUtils.toBean(s1, LoginData.class);
            if (loginData.getReturnCode() == 0) {
                //存入缓存
                userCache.saveUserId(loginData.getData().getUser_id(), loginData.getData().getReal_name_cn());

                //成功
                return ResultGenerator.genSuccessResult(loginData.getData());
            } else {
                return ResultGenerator.genFailResult("失败：" + loginData.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("-------登录失败------返回默认用户");
            LoginUserBean loginUserBean = new LoginUserBean();
            loginUserBean.setCode(1000);
            loginUserBean.setUser_id("761b5378-e843-4df3-a7aa-53965311814f");
            loginUserBean.setReal_name_cn("鲍春智");
            userCache.saveUserId("761b5378-e843-4df3-a7aa-53965311814f", "鲍春智");
            //成功
            return ResultGenerator.genFailResult(ResultCode.LOGIN_FAIL_ERROR,"登录失败");
            //return ResultGenerator.genSuccessResult(loginUserBean);
        }

    }

    public BaseData menu(HttpServletRequest request) {
        String userId = request.getAttribute("userId").toString();

        String s = "SystemCode=" + systemCode + "&UserId=" + userId;
        String sign = DigestUtil.md5Hex(s + "&Key=" + Key).toUpperCase();
        String resultStr = s + "&SignMsg=" + sign;
        logger.info("最终请求的字符串是：" + resultStr);

        Map<String, String> map = new HashMap<>(8);
        map.put("SystemCode", systemCode);
        map.put("UserId", userId);
        map.put("SignMsg", sign);
        try {
            MenuData menuData = restTemplate.postForEntity("http://10.1.15.102:10299/api/User/GetUserMenu", map,
             MenuData
                    .class)
                    .getBody();
            //MenuData menuData = restTemplate.postForEntity("http://localhost:8888/user/login1", map, MenuData
            //        .class)
            //        .getBody();
            if (menuData.getReturnCode() == 0) {
                return ResultGenerator.genSuccessResult(menuData.getData());
            } else {
                return ResultGenerator.genFailResult("失败" + menuData.getMessage());
            }
        } catch (Exception e) {
            MenuData menuData = new MenuData();
            menuData.setReturnCode(0);
            menuData.setMessage("aa");
            Menu menu = new Menu();
            menu.setApp_id("11");
            menu.setCode("12");

            Menu menu1 = new Menu();
            menu1.setApp_id("222");

            menu.setChild_menu(Arrays.asList(menu1));
            return ResultGenerator.genSuccessResult(menuData.getData());
        }

    }


}
