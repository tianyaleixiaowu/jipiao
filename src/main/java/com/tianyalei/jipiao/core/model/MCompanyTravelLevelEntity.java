package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.*;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyTravelLevel", catalog = "")
public class MCompanyTravelLevelEntity extends BaseIdEntity {
    private int companyId;
    private byte level;
    private String levelName;
    private String levelType;
    private boolean isEnable = true;

    @Override
    public String toString() {
        return "MCompanyTravelLevelEntity{" +
                "companyId=" + companyId +
                ", level=" + level +
                ", levelName='" + levelName + '\'' +
                ", levelType='" + levelType + '\'' +
                ", isEnable=" + isEnable +
                ", cities='" + cities + '\'' +
                '}';
    }

    /**
     * 添加的是城市时，城市id的集合，逗号分隔
     */
    @Transient
    private String cities;

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

    @Basic
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "Level")
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "LevelName")
    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Basic
    @Column(name = "LevelType")
    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }


}
