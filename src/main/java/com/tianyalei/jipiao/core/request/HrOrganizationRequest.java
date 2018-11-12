package com.tianyalei.jipiao.core.request;

import com.tianyalei.jipiao.core.model.MHrOrganizationEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/12.
 */
public class HrOrganizationRequest {
    private List<MHrOrganizationEntity> list = new ArrayList<>();

    public List<MHrOrganizationEntity> getList() {
        return list;
    }

    public void setList(List<MHrOrganizationEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HrOrganizationRequest{" +
                "list=" + list +
                '}';
    }
}
