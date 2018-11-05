package com.tianyalei.jipiao.core.model;

import javax.persistence.*;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_Dictionary", catalog = "")
public class MDictionaryEntity {
    private Integer id;
    private int groupId;
    private int sortId;
    private String dKey;
    private String dValue;
    private String dDescribe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GroupID")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "SortID")
    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    @Basic
    @Column(name = "DKey")
    public String getdKey() {
        return dKey;
    }

    public void setdKey(String dKey) {
        this.dKey = dKey;
    }

    @Basic
    @Column(name = "DValue")
    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }

    @Basic
    @Column(name = "DDescribe")
    public String getdDescribe() {
        return dDescribe;
    }

    public void setdDescribe(String dDescribe) {
        this.dDescribe = dDescribe;
    }
}
