package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyTravelSettingHotel", catalog = "")
public class MCompanyTravelSettingHotelEntity extends BaseIdEntity {
    private int travelLevelId;
    private int cityLevelId;
    private BigDecimal hotelFeeValue;
    private String currency;

    @Override
    public String toString() {
        return "MCompanyTravelSettingHotelEntity{" +
                "travelLevelId=" + travelLevelId +
                ", cityLevelId=" + cityLevelId +
                ", hotelFeeValue=" + hotelFeeValue +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Basic
    @Column(name = "TravelLevelID")
    public int getTravelLevelId() {
        return travelLevelId;
    }

    public void setTravelLevelId(int travelLevelId) {
        this.travelLevelId = travelLevelId;
    }

    @Basic
    @Column(name = "CityLevelID")
    public int getCityLevelId() {
        return cityLevelId;
    }

    public void setCityLevelId(int cityLevelId) {
        this.cityLevelId = cityLevelId;
    }

    @Basic
    @Column(name = "HotelFeeValue")
    public BigDecimal getHotelFeeValue() {
        return hotelFeeValue;
    }

    public void setHotelFeeValue(BigDecimal hotelFeeValue) {
        this.hotelFeeValue = hotelFeeValue;
    }

    @Basic
    @Column(name = "Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
