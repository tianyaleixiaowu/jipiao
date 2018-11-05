package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeReceiptCheckDetail", catalog = "")
public class MTicketOfficeReceiptCheckDetailEntity {
    private int id;
    private int receiptCheckId;
    private String beginNo;
    private String endNo;
    private short num;
    private byte isActivate;
    private String activateUser;
    private String activateUserName;
    private Timestamp activateTime;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ReceiptCheckID")
    public int getReceiptCheckId() {
        return receiptCheckId;
    }

    public void setReceiptCheckId(int receiptCheckId) {
        this.receiptCheckId = receiptCheckId;
    }

    @Basic
    @Column(name = "BeginNO")
    public String getBeginNo() {
        return beginNo;
    }

    public void setBeginNo(String beginNo) {
        this.beginNo = beginNo;
    }

    @Basic
    @Column(name = "EndNO")
    public String getEndNo() {
        return endNo;
    }

    public void setEndNo(String endNo) {
        this.endNo = endNo;
    }

    @Basic
    @Column(name = "Num")
    public short getNum() {
        return num;
    }

    public void setNum(short num) {
        this.num = num;
    }

    @Basic
    @Column(name = "IsActivate")
    public byte getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(byte isActivate) {
        this.isActivate = isActivate;
    }

    @Basic
    @Column(name = "ActivateUser")
    public String getActivateUser() {
        return activateUser;
    }

    public void setActivateUser(String activateUser) {
        this.activateUser = activateUser;
    }

    @Basic
    @Column(name = "ActivateUserName")
    public String getActivateUserName() {
        return activateUserName;
    }

    public void setActivateUserName(String activateUserName) {
        this.activateUserName = activateUserName;
    }

    @Basic
    @Column(name = "ActivateTime")
    public Timestamp getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Timestamp activateTime) {
        this.activateTime = activateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTicketOfficeReceiptCheckDetailEntity that = (MTicketOfficeReceiptCheckDetailEntity) o;
        return id == that.id &&
                receiptCheckId == that.receiptCheckId &&
                num == that.num &&
                isActivate == that.isActivate &&
                Objects.equals(beginNo, that.beginNo) &&
                Objects.equals(endNo, that.endNo) &&
                Objects.equals(activateUser, that.activateUser) &&
                Objects.equals(activateUserName, that.activateUserName) &&
                Objects.equals(activateTime, that.activateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, receiptCheckId, beginNo, endNo, num, isActivate, activateUser, activateUserName, activateTime);
    }
}
