package com.tianyalei.jipiao.core.bean;

/**
 * @author wuweifeng wrote on 2018/4/16.
 */
public class LoginData {
    private Integer ReturnCode;
    private String Message;
    private String Status;
    private LoginUserBean Data;

    public Integer getReturnCode() {
        return ReturnCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setReturnCode(Integer returnCode) {
        ReturnCode = returnCode;
    }

    public LoginUserBean getData() {
        return Data;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "ReturnCode=" + ReturnCode +
                ", Message='" + Message + '\'' +
                ", Status='" + Status + '\'' +
                ", Data=" + Data +
                '}';
    }

    public void setData(LoginUserBean data) {
        Data = data;
    }
}
