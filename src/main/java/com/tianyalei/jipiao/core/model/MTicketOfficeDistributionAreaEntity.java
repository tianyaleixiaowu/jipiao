package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
* 配送区域表
* @author Bai
* @date 2019/01/08 11:55
*/
@Entity
@Table(name = "M_TicketOfficeDistributionArea", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MTicketOfficeDistributionAreaEntity extends BaseIdEntity{

        /**
        *票台编号
        */
        @Basic
        @Column(name = "TicketOfficeID")
        private Integer ticketOfficeID;
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
        private Integer provinceID;
        /**
        *市
        */
        @Basic
        @Column(name = "City")
        private String city;
        /**
        *
        */
        @Basic
        @Column(name = "CityID")
        private Integer cityID;
        /**
        *区
        */
        @Basic
        @Column(name = "District")
        private String district;
        /**
        *
        */
        @Basic
        @Column(name = "DistrictID")
        private Integer districtID;
        /**
        *详细地址
        */
        @Basic
        @Column(name = "DetailedAddress")
        private String detailedAddress;
        /**
        *配送开始时间
        */
        @Basic
        @Column(name = "DistributionBeginTime")
        private Date distributionBeginTime;
        /**
        *配送结束时间
        */
        @Basic
        @Column(name = "DistributionEndTime")
        private Date distributionEndTime;
        /**
        *是否可用
        */
        @Basic
        @Column(name = "IsEnabled")
        private Byte isEnabled;




        public Integer getTicketOfficeID() {
        return this.ticketOfficeID;
        }
        public void setTicketOfficeID(Integer ticketOfficeID) {
        this.ticketOfficeID = ticketOfficeID;
        }


        public String getProvince() {
        return this.province;
        }
        public void setProvince(String province) {
        this.province = province;
        }








        public Integer getProvinceID() {
        return this.provinceID;
        }
        public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
        }


        public String getCity() {
        return this.city;
        }
        public void setCity(String city) {
        this.city = city;
        }








        public Integer getCityID() {
        return this.cityID;
        }
        public void setCityID(Integer cityID) {
        this.cityID = cityID;
        }


        public String getDistrict() {
        return this.district;
        }
        public void setDistrict(String district) {
        this.district = district;
        }








        public Integer getDistrictID() {
        return this.districtID;
        }
        public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
        }


        public String getDetailedAddress() {
        return this.detailedAddress;
        }
        public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
        }











        public Date getDistributionBeginTime() {
        return this.distributionBeginTime;
        }
        public void setDistributionBeginTime(Date distributionBeginTime) {
        this.distributionBeginTime = distributionBeginTime;
        }





        public Date getDistributionEndTime() {
        return this.distributionEndTime;
        }
        public void setDistributionEndTime(Date distributionEndTime) {
        this.distributionEndTime = distributionEndTime;
        }









        public Byte getIsEnabled() {
        return this.isEnabled;
        }
        public void setIsEnabled(Byte isEnabled) {
        this.isEnabled = isEnabled;
        }

}
