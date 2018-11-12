package com.tianyalei.jipiao.core.request;

import com.tianyalei.jipiao.core.model.MHrEmployeeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/12.
 */
public class HrEmployeeRequest {
    private List<MHrEmployeeEntity> list = new ArrayList<>();

    public List<MHrEmployeeEntity> getList() {
        return list;
    }

    public void setList(List<MHrEmployeeEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HrEmployeeRequest{" +
                "list=" + list +
                '}';
    }
}
