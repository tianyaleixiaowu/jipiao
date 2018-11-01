package com.tianyalei.jipiao.global.util;


import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public class CommonUtil {
    public static Date getNow() {
        return new Date();
    }

    /**
     * @param date
     *         年月日
     */
    public static Date dateOfStr(String date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String md5(String str) {
        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            return base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String randomUrl() {
        List<String> stringList = new ArrayList<>();
        String randomStr = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //输入10以内随机数
        Random random = new Random(System.currentTimeMillis());
        StringBuilder builStr = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            //random生成的是类似[0,1),左包含又不包含的数，所以要+1
            char tempC = randomStr.charAt(random.nextInt(randomStr.length()));
            builStr.append(tempC);
        }
        return builStr.toString();
    }


    /**
     * 生成uuid
     */
    public static String token() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
