package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
* 差旅单位表
* @author Bai
* @date 2019/01/08 11:55
*/
@Entity
@Table(name = "M_TicketOfficeTravelCompany", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MTicketOfficeTravelCompanyEntity extends BaseIdEntity{

        /**
        *票台ID
        */
        @Basic
        @Column(name = "TicketOfficeID")
        private Integer ticketOfficeID;
        /**
        *单位代码
        */
        @Basic
        @Column(name = "CompanyID")
        private String companyID;
        /**
        *单位名称
        */
        @Basic
        @Column(name = "CompanyName")
        private String companyName;
        /**
        *预订有效开始时间
        */
        @Basic
        @Column(name = "ResValidSTime")
        private Date resValidSTime;
        /**
        *预订有效结束时间
        */
        @Basic
        @Column(name = "ResValidETime")
        private Date resValidETime;
        /**
        *审核方式
        */
        @Basic
        @Column(name = "CheckType")
        private String checkType;
        /**
        *支付方式
        */
        @Basic
        @Column(name = "PaymentType")
        private String paymentType;
        /**
        *是否上传网报
        */
        @Basic
        @Column(name = "IsUploadNet")
        private Byte isUploadNet;
        /**
        *地址
        */
        @Basic
        @Column(name = "CompanyAddress")
        private String companyAddress;
        /**
        *联系人
        */
        @Basic
        @Column(name = "Linkman")
        private String linkman;
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
        @Column(name = "IsFreeReturnCost")
        private Byte isFreeReturnCost;




        public Integer getTicketOfficeID() {
        return this.ticketOfficeID;
        }
        public void setTicketOfficeID(Integer ticketOfficeID) {
        this.ticketOfficeID = ticketOfficeID;
        }


        public String getCompanyID() {
        return this.companyID;
        }
        public void setCompanyID(String companyID) {
        this.companyID = companyID;
        }





        public String getCompanyName() {
        return this.companyName;
        }
        public void setCompanyName(String companyName) {
        this.companyName = companyName;
        }






        public Date getResValidSTime() {
        return this.resValidSTime;
        }
        public void setResValidSTime(Date resValidSTime) {
        this.resValidSTime = resValidSTime;
        }





        public Date getResValidETime() {
        return this.resValidETime;
        }
        public void setResValidETime(Date resValidETime) {
        this.resValidETime = resValidETime;
        }




        public String getCheckType() {
        return this.checkType;
        }
        public void setCheckType(String checkType) {
        this.checkType = checkType;
        }





        public String getPaymentType() {
        return this.paymentType;
        }
        public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        }










        public Byte getIsUploadNet() {
        return this.isUploadNet;
        }
        public void setIsUploadNet(Byte isUploadNet) {
        this.isUploadNet = isUploadNet;
        }
        public String getCompanyAddress() {
        return this.companyAddress;
        }
        public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        }





        public String getLinkman() {
        return this.linkman;
        }
        public void setLinkman(String linkman) {
        this.linkman = linkman;
        }





        public String getLinkPhone() {
        return this.linkPhone;
        }
        public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
        }










        public Byte getIsFreeReturnCost() {
        return this.isFreeReturnCost;
        }
        public void setIsFreeReturnCost(Byte isFreeReturnCost) {
        this.isFreeReturnCost = isFreeReturnCost;
        }

}
