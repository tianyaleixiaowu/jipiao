package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyTravelSetting", catalog = "")
public class MCompanyTravelSettingEntity extends BaseEntity  {
    private int travelLevelId;
    private String planeLevel;
    private String trainLevel;


    @Basic
    @Column(name = "TravelLevelID")
    public int getTravelLevelId() {
        return travelLevelId;
    }

    public void setTravelLevelId(int travelLevelId) {
        this.travelLevelId = travelLevelId;
    }

    @Basic
    @Column(name = "PlaneLevel")
    public String getPlaneLevel() {
        return planeLevel;
    }

    public void setPlaneLevel(String planeLevel) {
        this.planeLevel = planeLevel;
    }

    @Basic
    @Column(name = "TrainLevel")
    public String getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(String trainLevel) {
        this.trainLevel = trainLevel;
    }

}
