package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeNoticeRead", catalog = "")
public class MTicketOfficeNoticeReadEntity extends BaseIdEntity {
    private int noticeId;
    private byte isRead;


    @Basic
    @Column(name = "NoticeID")
    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    @Basic
    @Column(name = "IsRead")
    public byte getIsRead() {
        return isRead;
    }

    public void setIsRead(byte isRead) {
        this.isRead = isRead;
    }

}
