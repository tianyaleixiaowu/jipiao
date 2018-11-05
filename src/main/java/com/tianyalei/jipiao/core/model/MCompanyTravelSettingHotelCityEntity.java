package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyTravelSettingHotelCity", catalog = "")
public class MCompanyTravelSettingHotelCityEntity extends BaseIdEntity {
    private int cityLevelId;
    private String cityId;
    private String cityName;

    @Basic
    @Column(name = "CityLevelID")
    public int getCityLevelId() {
        return cityLevelId;
    }

    public void setCityLevelId(int cityLevelId) {
        this.cityLevelId = cityLevelId;
    }

    @Basic
    @Column(name = "CityID")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CityName")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
