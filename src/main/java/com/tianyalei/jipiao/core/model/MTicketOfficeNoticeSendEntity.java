package com.tianyalei.jipiao.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeNoticeSend", catalog = "")
public class MTicketOfficeNoticeSendEntity implements Serializable {
    private int noticeId;
    private int ticketOfficeId;

    @Id
    @Column(name = "NoticeID")
    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    @Id
    @Column(name = "TicketOfficeID")
    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTicketOfficeNoticeSendEntity that = (MTicketOfficeNoticeSendEntity) o;
        return noticeId == that.noticeId &&
                ticketOfficeId == that.ticketOfficeId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(noticeId, ticketOfficeId);
    }
}
