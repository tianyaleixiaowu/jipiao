package com.tianyalei.jipiao.global.cache;

import com.xiaoleilu.hutool.util.ObjectUtil;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/4/17.
 */
@Component
public class UserCache {
    @Resource
    private Cache cache;

    public void saveUserId(String userId, String realName) {
        cache.put(userId, realName);
    }

    public String findNameByUserId(String userId) {
        if (ObjectUtil.isNull(cache.get(userId))) {
            return "";
        }
        return cache.get(userId).get().toString();
    }
}
