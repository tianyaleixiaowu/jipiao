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

    public static String aesEncode(String content) {
        return EncryptUtil.encryptBase64(content, "vX6LicvxUgZoVPUB");
    }

    public static String aesDecode(String content) {
        //return EncryptUtil.decryptBase64(content, "f3b18dffb528d2fbdc61be6aca3f838c");
        return EncryptUtil.decryptBase64(content, "vX6LicvxUgZoVPUB");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //System.out.println(aesEncode("8UW06P9XhBpfkwZL"));
        //System.out.println(aesDecode(""));
        System.out.println("啊".getBytes().length == "啊".length());
        System.out.println("A".getBytes().length == "A".length());
    }

    /**
     * 通过身份证号码获取出生日期、性别、年龄
     *
     * @param certificateNo
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public static Map<String, String> getBirAgeSex(String certificateNo) {
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) {
                    return new HashMap<>();
                }
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) {
                    return new HashMap<>();
                }
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) %
                    2 == 0 ? "0" : "1";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() -
                    1)) % 2 == 0 ? "0" : "1";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
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
