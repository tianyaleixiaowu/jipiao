package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberAircard", catalog = "")
public class MMemberAircardEntity extends BaseIdEntity {
    private String cardNum;
    private byte airCardType;
    private String airCardNum;
    private byte isEnable;


    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "AirCardType")
    public byte getAirCardType() {
        return airCardType;
    }

    public void setAirCardType(byte airCardType) {
        this.airCardType = airCardType;
    }

    @Basic
    @Column(name = "AirCardNum")
    public String getAirCardNum() {
        return airCardNum;
    }

    public void setAirCardNum(String airCardNum) {
        this.airCardNum = airCardNum;
    }

    @Basic
    @Column(name = "IsEnable")
    public byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(byte isEnable) {
        this.isEnable = isEnable;
    }

}
