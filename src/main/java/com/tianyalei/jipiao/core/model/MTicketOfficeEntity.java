package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
* 票台表
* @author Bai
* @date 2019/01/08 11:55
*/
@Entity
@Table(name = "M_TicketOffice", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MTicketOfficeEntity extends BaseIdEntity{

        /**
        *代理商编号
        */
        @Basic
        @Column(name = "AgentID")
        private Integer agentID;
        /**
        *票台名称
        */
        @Basic
        @Column(name = "TicketOfficeName")
        private String ticketOfficeName;
        /**
        *
        */
        @Basic
        @Column(name = "TicketDistrict")
        private String ticketDistrict;
        /**
        *
        */
        @Basic
        @Column(name = "TicketDistrictID")
        private String ticketDistrictID;
        /**
        *省
        */
        @Basic
        @Column(name = "Province")
        private String province;
        /**
        *省ID
        */
        @Basic
        @Column(name = "ProvinceID")
        private String provinceID;
        /**
        *市
        */
        @Basic
        @Column(name = "City")
        private String city;
        /**
        *市ID
        */
        @Basic
        @Column(name = "CityID")
        private String cityID;
        /**
        *城市代码
        */
        @Basic
        @Column(name = "CityCode")
        private String cityCode;
        /**
        *区
        */
        @Basic
        @Column(name = "District")
        private String district;
        /**
        *区ID
        */
        @Basic
        @Column(name = "DistrictID")
        private String districtID;
        /**
        *详细地址
        */
        @Basic
        @Column(name = "DetailedAddress")
        private String detailedAddress;
        /**
        *联系电话
        */
        @Basic
        @Column(name = "LinkPhone")
        private String linkPhone;
        /**
        *
        */
        @Basic
        @Column(name = "BackupPhone")
        private String backupPhone;
        /**
        *传真号码
        */
        @Basic
        @Column(name = "Fax")
        private String fax;
        /**
        *是否邮寄
        */
        @Basic
        @Column(name = "IsPost")
        private Byte isPost;
        /**
        *是否自取
        */
        @Basic
        @Column(name = "IsSelfTake")
        private Byte isSelfTake;
        /**
        *是否POS
        */
        @Basic
        @Column(name = "IsPos")
        private Byte isPos;
        /**
        *是否自有票台
        */
        @Basic
        @Column(name = "IsSelfTicketOffice")
        private Byte isSelfTicketOffice;
        /**
        *出票开始时间
        */
        @Basic
        @Column(name = "TKTBeginTime")
        private Date tKTBeginTime;
        /**
        *出票结束时间
        */
        @Basic
        @Column(name = "TKTEndTime")
        private Date tKTEndTime;
        /**
        *取票开始时间
        */
        @Basic
        @Column(name = "SelfTakeBeginTime")
        private Date selfTakeBeginTime;
        /**
        *取票结束时间
        */
        @Basic
        @Column(name = "SelfTakeEndTime")
        private Date selfTakeEndTime;
        /**
        *是否可用
        */
        @Basic
        @Column(name = "IsEnabled")
        private Byte isEnabled;




        public Integer getAgentID() {
        return this.agentID;
        }
        public void setAgentID(Integer agentID) {
        this.agentID = agentID;
        }


        public String getTicketOfficeName() {
        return this.ticketOfficeName;
        }
        public void setTicketOfficeName(String ticketOfficeName) {
        this.ticketOfficeName = ticketOfficeName;
        }





        public String getTicketDistrict() {
        return this.ticketDistrict;
        }
        public void setTicketDistrict(String ticketDistrict) {
        this.ticketDistrict = ticketDistrict;
        }





        public String getTicketDistrictID() {
        return this.ticketDistrictID;
        }
        public void setTicketDistrictID(String ticketDistrictID) {
        this.ticketDistrictID = ticketDistrictID;
        }





        public String getProvince() {
        return this.province;
        }
        public void setProvince(String province) {
        this.province = province;
        }





        public String getProvinceID() {
        return this.provinceID;
        }
        public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
        }





        public String getCity() {
        return this.city;
        }
        public void setCity(String city) {
        this.city = city;
        }





        public String getCityID() {
        return this.cityID;
        }
        public void setCityID(String cityID) {
        this.cityID = cityID;
        }





        public String getCityCode() {
        return this.cityCode;
        }
        public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
        }





        public String getDistrict() {
        return this.district;
        }
        public void setDistrict(String district) {
        this.district = district;
        }





        public String getDistrictID() {
        return this.districtID;
        }
        public void setDistrictID(String districtID) {
        this.districtID = districtID;
        }





        public String getDetailedAddress() {
        return this.detailedAddress;
        }
        public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
        }





        public String getLinkPhone() {
        return this.linkPhone;
        }
        public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
        }





        public String getBackupPhone() {
        return this.backupPhone;
        }
        public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
        }





        public String getFax() {
        return this.fax;
        }
        public void setFax(String fax) {
        this.fax = fax;
        }










        public Byte getIsPost() {
        return this.isPost;
        }
        public void setIsPost(Byte isPost) {
        this.isPost = isPost;
        }





        public Byte getIsSelfTake() {
        return this.isSelfTake;
        }
        public void setIsSelfTake(Byte isSelfTake) {
        this.isSelfTake = isSelfTake;
        }





        public Byte getIsPos() {
        return this.isPos;
        }
        public void setIsPos(Byte isPos) {
        this.isPos = isPos;
        }





        public Byte getIsSelfTicketOffice() {
        return this.isSelfTicketOffice;
        }
        public void setIsSelfTicketOffice(Byte isSelfTicketOffice) {
        this.isSelfTicketOffice = isSelfTicketOffice;
        }

        public Date getTKTBeginTime() {
        return this.tKTBeginTime;
        }
        public void setTKTBeginTime(Date tKTBeginTime) {
        this.tKTBeginTime = tKTBeginTime;
        }





        public Date getTKTEndTime() {
        return this.tKTEndTime;
        }
        public void setTKTEndTime(Date tKTEndTime) {
        this.tKTEndTime = tKTEndTime;
        }





        public Date getSelfTakeBeginTime() {
        return this.selfTakeBeginTime;
        }
        public void setSelfTakeBeginTime(Date selfTakeBeginTime) {
        this.selfTakeBeginTime = selfTakeBeginTime;
        }





        public Date getSelfTakeEndTime() {
        return this.selfTakeEndTime;
        }
        public void setSelfTakeEndTime(Date selfTakeEndTime) {
        this.selfTakeEndTime = selfTakeEndTime;
        }









        public Byte getIsEnabled() {
        return this.isEnabled;
        }
        public void setIsEnabled(Byte isEnabled) {
        this.isEnabled = isEnabled;
        }

}
