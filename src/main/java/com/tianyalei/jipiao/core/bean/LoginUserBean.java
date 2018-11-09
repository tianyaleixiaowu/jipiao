package com.tianyalei.jipiao.core.bean;

/**
 * 登录原系统的返回值
 * @author wuweifeng wrote on 2018/11/9.
 */
public class LoginUserBean {
    private Integer code;
    private String user_id;
    private String real_name_cn;

    @Override
    public String toString() {
        return "LoginUserBean{" +
                "code=" + code +
                ", user_id='" + user_id + '\'' +
                ", real_name_cn='" + real_name_cn + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReal_name_cn() {
        return real_name_cn;
    }

    public void setReal_name_cn(String real_name_cn) {
        this.real_name_cn = real_name_cn;
    }
}
