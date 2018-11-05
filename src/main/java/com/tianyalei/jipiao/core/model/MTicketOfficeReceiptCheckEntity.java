package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeReceiptCheck", catalog = "")
public class MTicketOfficeReceiptCheckEntity {
    private int id;
    private int ticketOfficeId;
    private Short applyTravelItineraryNum;
    private Short applyInsuranceNum;
    private String applyReason;
    private String applyUser;
    private String applyUserName;
    private Timestamp applyTime;
    private String checkStatus;
    private String checkResult;
    private Short checkInsuranceNum;
    private Short checkTravelItineraryNum;
    private String checkReason;
    private String checkUser;
    private String checkUserName;
    private Timestamp checkTime;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TicketOfficeID")
    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    @Basic
    @Column(name = "ApplyTravelItineraryNum")
    public Short getApplyTravelItineraryNum() {
        return applyTravelItineraryNum;
    }

    public void setApplyTravelItineraryNum(Short applyTravelItineraryNum) {
        this.applyTravelItineraryNum = applyTravelItineraryNum;
    }

    @Basic
    @Column(name = "ApplyInsuranceNum")
    public Short getApplyInsuranceNum() {
        return applyInsuranceNum;
    }

    public void setApplyInsuranceNum(Short applyInsuranceNum) {
        this.applyInsuranceNum = applyInsuranceNum;
    }

    @Basic
    @Column(name = "ApplyReason")
    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    @Basic
    @Column(name = "ApplyUser")
    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    @Basic
    @Column(name = "ApplyUserName")
    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    @Basic
    @Column(name = "ApplyTime")
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "CheckStatus")
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Basic
    @Column(name = "CheckResult")
    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    @Basic
    @Column(name = "CheckInsuranceNum")
    public Short getCheckInsuranceNum() {
        return checkInsuranceNum;
    }

    public void setCheckInsuranceNum(Short checkInsuranceNum) {
        this.checkInsuranceNum = checkInsuranceNum;
    }

    @Basic
    @Column(name = "CheckTravelItineraryNum")
    public Short getCheckTravelItineraryNum() {
        return checkTravelItineraryNum;
    }

    public void setCheckTravelItineraryNum(Short checkTravelItineraryNum) {
        this.checkTravelItineraryNum = checkTravelItineraryNum;
    }

    @Basic
    @Column(name = "CheckReason")
    public String getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    @Basic
    @Column(name = "CheckUser")
    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    @Basic
    @Column(name = "CheckUserName")
    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    @Basic
    @Column(name = "CheckTime")
    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTicketOfficeReceiptCheckEntity that = (MTicketOfficeReceiptCheckEntity) o;
        return id == that.id &&
                ticketOfficeId == that.ticketOfficeId &&
                Objects.equals(applyTravelItineraryNum, that.applyTravelItineraryNum) &&
                Objects.equals(applyInsuranceNum, that.applyInsuranceNum) &&
                Objects.equals(applyReason, that.applyReason) &&
                Objects.equals(applyUser, that.applyUser) &&
                Objects.equals(applyUserName, that.applyUserName) &&
                Objects.equals(applyTime, that.applyTime) &&
                Objects.equals(checkStatus, that.checkStatus) &&
                Objects.equals(checkResult, that.checkResult) &&
                Objects.equals(checkInsuranceNum, that.checkInsuranceNum) &&
                Objects.equals(checkTravelItineraryNum, that.checkTravelItineraryNum) &&
                Objects.equals(checkReason, that.checkReason) &&
                Objects.equals(checkUser, that.checkUser) &&
                Objects.equals(checkUserName, that.checkUserName) &&
                Objects.equals(checkTime, that.checkTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ticketOfficeId, applyTravelItineraryNum, applyInsuranceNum, applyReason, applyUser,
                applyUserName, applyTime, checkStatus, checkResult, checkInsuranceNum, checkTravelItineraryNum, checkReason, checkUser, checkUserName, checkTime);
    }
}
