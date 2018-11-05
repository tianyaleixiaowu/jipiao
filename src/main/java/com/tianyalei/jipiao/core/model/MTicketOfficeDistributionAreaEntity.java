package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeDistributionArea", catalog = "")
public class MTicketOfficeDistributionAreaEntity  extends BaseEntity {
    private int ticketOfficeId;
    private String province;
    private Integer provinceId;
    private String city;
    private Integer cityId;
    private String district;
    private Integer districtId;
    private String detailedAddress;
    private Short needTime;
    private Timestamp distributionBeginTime;
    private Timestamp distributionEndTime;
    private byte isEnabled;

    @Basic
    @Column(name = "TicketOfficeID")
    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    @Basic
    @Column(name = "Province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "ProvinceID")
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "CityID")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "District")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "DistrictID")
    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "DetailedAddress")
    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    @Basic
    @Column(name = "NeedTime")
    public Short getNeedTime() {
        return needTime;
    }

    public void setNeedTime(Short needTime) {
        this.needTime = needTime;
    }

    @Basic
    @Column(name = "DistributionBeginTime")
    public Timestamp getDistributionBeginTime() {
        return distributionBeginTime;
    }

    public void setDistributionBeginTime(Timestamp distributionBeginTime) {
        this.distributionBeginTime = distributionBeginTime;
    }

    @Basic
    @Column(name = "DistributionEndTime")
    public Timestamp getDistributionEndTime() {
        return distributionEndTime;
    }

    public void setDistributionEndTime(Timestamp distributionEndTime) {
        this.distributionEndTime = distributionEndTime;
    }

    @Basic
    @Column(name = "IsEnabled")
    public byte getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(byte isEnabled) {
        this.isEnabled = isEnabled;
    }

}
