package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 会员积分等级表
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberGrade", catalog = "")
public class MMemberGradeEntity {
    private int id;
    private String memberGradeName;
    private int startPoint;
    private int endPoint;
    private BigDecimal hotelPointRate;
    private BigDecimal ticketPointRate;
    private BigDecimal hotelWebPointRate;
    private BigDecimal ticketWebPointRate;
    private String createUserId;
    private String createRealName;
    private Timestamp createTime;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MemberGradeName")
    public String getMemberGradeName() {
        return memberGradeName;
    }

    public void setMemberGradeName(String memberGradeName) {
        this.memberGradeName = memberGradeName;
    }

    @Basic
    @Column(name = "StartPoint")
    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    @Basic
    @Column(name = "EndPoint")
    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    @Basic
    @Column(name = "HotelPointRate")
    public BigDecimal getHotelPointRate() {
        return hotelPointRate;
    }

    public void setHotelPointRate(BigDecimal hotelPointRate) {
        this.hotelPointRate = hotelPointRate;
    }

    @Basic
    @Column(name = "TicketPointRate")
    public BigDecimal getTicketPointRate() {
        return ticketPointRate;
    }

    public void setTicketPointRate(BigDecimal ticketPointRate) {
        this.ticketPointRate = ticketPointRate;
    }

    @Basic
    @Column(name = "HotelWebPointRate")
    public BigDecimal getHotelWebPointRate() {
        return hotelWebPointRate;
    }

    public void setHotelWebPointRate(BigDecimal hotelWebPointRate) {
        this.hotelWebPointRate = hotelWebPointRate;
    }

    @Basic
    @Column(name = "TicketWebPointRate")
    public BigDecimal getTicketWebPointRate() {
        return ticketWebPointRate;
    }

    public void setTicketWebPointRate(BigDecimal ticketWebPointRate) {
        this.ticketWebPointRate = ticketWebPointRate;
    }

    @Basic
    @Column(name = "CreateUserID")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "CreateRealName")
    public String getCreateRealName() {
        return createRealName;
    }

    public void setCreateRealName(String createRealName) {
        this.createRealName = createRealName;
    }

    @Basic
    @Column(name = "CreateTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MMemberGradeEntity that = (MMemberGradeEntity) o;
        return id == that.id &&
                startPoint == that.startPoint &&
                endPoint == that.endPoint &&
                Objects.equals(memberGradeName, that.memberGradeName) &&
                Objects.equals(hotelPointRate, that.hotelPointRate) &&
                Objects.equals(ticketPointRate, that.ticketPointRate) &&
                Objects.equals(hotelWebPointRate, that.hotelWebPointRate) &&
                Objects.equals(ticketWebPointRate, that.ticketWebPointRate) &&
                Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(createRealName, that.createRealName) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, memberGradeName, startPoint, endPoint, hotelPointRate, ticketPointRate, hotelWebPointRate, ticketWebPointRate, createUserId, createRealName, createTime);
    }
}
