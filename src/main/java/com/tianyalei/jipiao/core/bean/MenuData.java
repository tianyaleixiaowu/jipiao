package com.tianyalei.jipiao.core.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/4/16.
 */
public class MenuData {
    private Integer ReturnCode;
    private String Message;
    private String Status;
    private List<Menu> Data = new ArrayList<>();

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

    public List<Menu> getData() {
        return Data;
    }

    public void setData(List<Menu> data) {
        Data = data;
    }
}
