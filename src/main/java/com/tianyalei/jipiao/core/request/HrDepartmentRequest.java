package com.tianyalei.jipiao.core.request;

import com.tianyalei.jipiao.core.model.MHrDepartmentEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/12.
 */
public class HrDepartmentRequest {
    private List<MHrDepartmentEntity> list = new ArrayList<>();

    public List<MHrDepartmentEntity> getList() {
        return list;
    }

    public void setList(List<MHrDepartmentEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HrDepartmentRequest{" +
                "list=" + list +
                '}';
    }
}
