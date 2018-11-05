package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeInsuranceCheckDetail", catalog = "")
public class MTicketOfficeInsuranceCheckDetailEntity {
    private int id;
    private int receiptCheckId;
    private String beginNo;
    private String endNo;
    private short num;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTicketOfficeInsuranceCheckDetailEntity that = (MTicketOfficeInsuranceCheckDetailEntity) o;
        return id == that.id &&
                receiptCheckId == that.receiptCheckId &&
                num == that.num &&
                Objects.equals(beginNo, that.beginNo) &&
                Objects.equals(endNo, that.endNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, receiptCheckId, beginNo, endNo, num);
    }
}
