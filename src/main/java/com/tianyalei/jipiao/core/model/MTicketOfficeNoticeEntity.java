package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeNotice", catalog = "")
public class MTicketOfficeNoticeEntity extends BaseEntity {
    private String noticeTitle;
    private String noticeContent;
    private Timestamp validBeginTime;
    private Timestamp validEndTime;
    private byte isEnabled;


    @Basic
    @Column(name = "NoticeTitle")
    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    @Basic
    @Column(name = "NoticeContent")
    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Basic
    @Column(name = "ValidBeginTime")
    public Timestamp getValidBeginTime() {
        return validBeginTime;
    }

    public void setValidBeginTime(Timestamp validBeginTime) {
        this.validBeginTime = validBeginTime;
    }

    @Basic
    @Column(name = "ValidEndTime")
    public Timestamp getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(Timestamp validEndTime) {
        this.validEndTime = validEndTime;
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
