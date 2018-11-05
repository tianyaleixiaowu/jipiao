package com.tianyalei.jipiao.global.sign;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public class AsciiSign {
    /**
     * 加签
     */
    public static String sign(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        String signKey = "Key=f3b18dffb528d2fbdc61be6aca3f838c";
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            Object value = map.get(key);
            sb.append(key + "=" + value + "&");
        }

        String signStr = sb.toString() + signKey;
        return DigestUtils.md5Hex(signStr).toUpperCase();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("abc", "123");
        map.put("cba", "111");
        map.put("bca", "222");
        sign(map);
        /**
         * output
         * 	before sign: abc=123&bca=222&cba=111111111
         after sign: c1f8a7c16bdb1f998f361d4dfafef4ee
         */

    }

}
