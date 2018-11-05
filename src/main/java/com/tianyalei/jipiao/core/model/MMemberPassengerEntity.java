package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberPassenger", catalog = "")
public class MMemberPassengerEntity extends BaseIdEntity {
    private String cardNum;
    private String passengerCardNum;
    private String passengerRealName;


    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "PassengerCardNum")
    public String getPassengerCardNum() {
        return passengerCardNum;
    }

    public void setPassengerCardNum(String passengerCardNum) {
        this.passengerCardNum = passengerCardNum;
    }

    @Basic
    @Column(name = "PassengerRealName")
    public String getPassengerRealName() {
        return passengerRealName;
    }

    public void setPassengerRealName(String passengerRealName) {
        this.passengerRealName = passengerRealName;
    }

}
