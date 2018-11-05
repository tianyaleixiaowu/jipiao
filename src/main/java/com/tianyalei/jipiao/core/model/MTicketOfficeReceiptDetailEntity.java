package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeReceiptDetail", catalog = "")
public class MTicketOfficeReceiptDetailEntity {
    private int ticketOfficeId;
    private String travelItineraryNo;
    private String ticketNum;
    private String travelItineraryStatus;
    private String usePerson;
    private String userName;
    private Timestamp useTime;
    private String isReceive;
    private String remarks;
    private String receiveUser;
    private String receiveUserName;
    private Timestamp receiveTime;

    @Basic
    @Column(name = "TicketOfficeID")
    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    @Id
    @Column(name = "TravelItineraryNO")
    public String getTravelItineraryNo() {
        return travelItineraryNo;
    }

    public void setTravelItineraryNo(String travelItineraryNo) {
        this.travelItineraryNo = travelItineraryNo;
    }

    @Basic
    @Column(name = "TicketNum")
    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Basic
    @Column(name = "TravelItineraryStatus")
    public String getTravelItineraryStatus() {
        return travelItineraryStatus;
    }

    public void setTravelItineraryStatus(String travelItineraryStatus) {
        this.travelItineraryStatus = travelItineraryStatus;
    }

    @Basic
    @Column(name = "UsePerson")
    public String getUsePerson() {
        return usePerson;
    }

    public void setUsePerson(String usePerson) {
        this.usePerson = usePerson;
    }

    @Basic
    @Column(name = "UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "UseTime")
    public Timestamp getUseTime() {
        return useTime;
    }

    public void setUseTime(Timestamp useTime) {
        this.useTime = useTime;
    }

    @Basic
    @Column(name = "IsReceive")
    public String getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(String isReceive) {
        this.isReceive = isReceive;
    }

    @Basic
    @Column(name = "Remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "ReceiveUser")
    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    @Basic
    @Column(name = "ReceiveUserName")
    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    @Basic
    @Column(name = "ReceiveTime")
    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTicketOfficeReceiptDetailEntity that = (MTicketOfficeReceiptDetailEntity) o;
        return ticketOfficeId == that.ticketOfficeId &&
                Objects.equals(travelItineraryNo, that.travelItineraryNo) &&
                Objects.equals(ticketNum, that.ticketNum) &&
                Objects.equals(travelItineraryStatus, that.travelItineraryStatus) &&
                Objects.equals(usePerson, that.usePerson) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(useTime, that.useTime) &&
                Objects.equals(isReceive, that.isReceive) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(receiveUser, that.receiveUser) &&
                Objects.equals(receiveUserName, that.receiveUserName) &&
                Objects.equals(receiveTime, that.receiveTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ticketOfficeId, travelItineraryNo, ticketNum, travelItineraryStatus, usePerson, userName, useTime, isReceive, remarks, receiveUser, receiveUserName, receiveTime);
    }
}
