package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOffice", catalog = "")
public class MTicketOfficeEntity extends BaseEntity {
    private int agentId;
    private String ticketOfficeName;
    private String ticketDistrict;
    private String ticketDistrictId;
    private String province;
    private String provinceId;
    private String city;
    private String cityId;
    private String cityCode;
    private String district;
    private String districtId;
    private String detailedAddress;
    private String linkPhone;
    private String backupPhone;
    private String fax;
    private byte isPost;
    private byte isSelfTake;
    private byte isPos;
    private byte isSelfTicketOffice;
    private Timestamp tktBeginTime;
    private Timestamp tktEndTime;
    private Timestamp selfTakeBeginTime;
    private Timestamp selfTakeEndTime;
    private byte isEnabled;

    @Basic
    @Column(name = "AgentID")
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Basic
    @Column(name = "TicketOfficeName")
    public String getTicketOfficeName() {
        return ticketOfficeName;
    }

    public void setTicketOfficeName(String ticketOfficeName) {
        this.ticketOfficeName = ticketOfficeName;
    }

    @Basic
    @Column(name = "TicketDistrict")
    public String getTicketDistrict() {
        return ticketDistrict;
    }

    public void setTicketDistrict(String ticketDistrict) {
        this.ticketDistrict = ticketDistrict;
    }

    @Basic
    @Column(name = "TicketDistrictID")
    public String getTicketDistrictId() {
        return ticketDistrictId;
    }

    public void setTicketDistrictId(String ticketDistrictId) {
        this.ticketDistrictId = ticketDistrictId;
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
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
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
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CityCode")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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
    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
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
    @Column(name = "LinkPhone")
    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    @Basic
    @Column(name = "BackupPhone")
    public String getBackupPhone() {
        return backupPhone;
    }

    public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
    }

    @Basic
    @Column(name = "Fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "IsPost")
    public byte getIsPost() {
        return isPost;
    }

    public void setIsPost(byte isPost) {
        this.isPost = isPost;
    }

    @Basic
    @Column(name = "IsSelfTake")
    public byte getIsSelfTake() {
        return isSelfTake;
    }

    public void setIsSelfTake(byte isSelfTake) {
        this.isSelfTake = isSelfTake;
    }

    @Basic
    @Column(name = "IsPos")
    public byte getIsPos() {
        return isPos;
    }

    public void setIsPos(byte isPos) {
        this.isPos = isPos;
    }

    @Basic
    @Column(name = "IsSelfTicketOffice")
    public byte getIsSelfTicketOffice() {
        return isSelfTicketOffice;
    }

    public void setIsSelfTicketOffice(byte isSelfTicketOffice) {
        this.isSelfTicketOffice = isSelfTicketOffice;
    }

    @Basic
    @Column(name = "TKTBeginTime")
    public Timestamp getTktBeginTime() {
        return tktBeginTime;
    }

    public void setTktBeginTime(Timestamp tktBeginTime) {
        this.tktBeginTime = tktBeginTime;
    }

    @Basic
    @Column(name = "TKTEndTime")
    public Timestamp getTktEndTime() {
        return tktEndTime;
    }

    public void setTktEndTime(Timestamp tktEndTime) {
        this.tktEndTime = tktEndTime;
    }

    @Basic
    @Column(name = "SelfTakeBeginTime")
    public Timestamp getSelfTakeBeginTime() {
        return selfTakeBeginTime;
    }

    public void setSelfTakeBeginTime(Timestamp selfTakeBeginTime) {
        this.selfTakeBeginTime = selfTakeBeginTime;
    }

    @Basic
    @Column(name = "SelfTakeEndTime")
    public Timestamp getSelfTakeEndTime() {
        return selfTakeEndTime;
    }

    public void setSelfTakeEndTime(Timestamp selfTakeEndTime) {
        this.selfTakeEndTime = selfTakeEndTime;
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
