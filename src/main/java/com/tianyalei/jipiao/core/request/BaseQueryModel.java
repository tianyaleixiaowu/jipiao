package com.tianyalei.jipiao.core.request;

/**
 * @author wuweifeng wrote on 2018/11/5.
 */
public class BaseQueryModel {
    private Integer page = 0;
    private Integer size = 10;

    @Override
    public String toString() {
        return "BaseModel{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
