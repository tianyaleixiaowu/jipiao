package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeUser", catalog = "")
public class MTicketOfficeUserEntity extends BaseEntity {
    private String userId;
    private int ticketOfficeId;
    private String realName;
    private String linkPhone;
    private String workNum;
    private byte isOperator;
    private boolean isEnable;
    private String relationTicketOffice;


    @Basic
    @Column(name = "UserID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    @Column(name = "RealName")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
    @Column(name = "WorkNum")
    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    @Basic
    @Column(name = "IsOperator")
    public byte getIsOperator() {
        return isOperator;
    }

    public void setIsOperator(byte isOperator) {
        this.isOperator = isOperator;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Basic
    @Column(name = "RelationTicketOffice")
    public String getRelationTicketOffice() {
        return relationTicketOffice;
    }

    public void setRelationTicketOffice(String relationTicketOffice) {
        this.relationTicketOffice = relationTicketOffice;
    }

}
