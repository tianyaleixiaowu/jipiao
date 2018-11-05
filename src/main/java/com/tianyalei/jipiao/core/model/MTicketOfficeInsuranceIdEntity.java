package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_TicketOfficeInsurance", catalog = "")
public class MTicketOfficeInsuranceIdEntity extends BaseIdEntity {
    private String beginNo;
    private String endNo;
    private short num;
    private String nowNo;
    private short surplus;
    private String remarks;


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
    @Column(name = "NowNo")
    public String getNowNo() {
        return nowNo;
    }

    public void setNowNo(String nowNo) {
        this.nowNo = nowNo;
    }

    @Basic
    @Column(name = "Surplus")
    public short getSurplus() {
        return surplus;
    }

    public void setSurplus(short surplus) {
        this.surplus = surplus;
    }

    @Basic
    @Column(name = "Remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
