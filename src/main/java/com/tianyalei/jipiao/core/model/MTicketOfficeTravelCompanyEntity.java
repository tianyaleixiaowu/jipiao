package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeTravelCompany", catalog = "")
public class MTicketOfficeTravelCompanyEntity extends BaseIdEntity {
    private int ticketOfficeId;
    private String companyId;
    private String companyName;
    private Timestamp resValidSTime;
    private Timestamp resValidETime;
    private String checkType;
    private String paymentType;
    private Byte isUploadNet;
    private String companyAddress;
    private String linkman;
    private String linkPhone;
    private Byte isFreeReturnCost;


    @Basic
    @Column(name = "TicketOfficeID")
    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    @Basic
    @Column(name = "CompanyID")
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "CompanyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "ResValidSTime")
    public Timestamp getResValidSTime() {
        return resValidSTime;
    }

    public void setResValidSTime(Timestamp resValidSTime) {
        this.resValidSTime = resValidSTime;
    }

    @Basic
    @Column(name = "ResValidETime")
    public Timestamp getResValidETime() {
        return resValidETime;
    }

    public void setResValidETime(Timestamp resValidETime) {
        this.resValidETime = resValidETime;
    }

    @Basic
    @Column(name = "CheckType")
    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    @Basic
    @Column(name = "PaymentType")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "IsUploadNet")
    public Byte getIsUploadNet() {
        return isUploadNet;
    }

    public void setIsUploadNet(Byte isUploadNet) {
        this.isUploadNet = isUploadNet;
    }

    @Basic
    @Column(name = "CompanyAddress")
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Basic
    @Column(name = "Linkman")
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
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
    @Column(name = "IsFreeReturnCost")
    public Byte getIsFreeReturnCost() {
        return isFreeReturnCost;
    }

    public void setIsFreeReturnCost(Byte isFreeReturnCost) {
        this.isFreeReturnCost = isFreeReturnCost;
    }

}
