package com.tianyalei.jipiao.core.request;

import com.tianyalei.jipiao.core.model.MHrRelationalEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/12.
 */
public class HrRelationRequest {
    private List<MHrRelationalEntity> list = new ArrayList<>();

    public List<MHrRelationalEntity> getList() {
        return list;
    }

    public void setList(List<MHrRelationalEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MHrRelationalEntity{" +
                "list=" + list +
                '}';
    }
}
