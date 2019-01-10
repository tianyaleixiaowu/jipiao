package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* 会员常旅客卡
* @author Bai
* @date 2019/01/07 11:11
*/
@Entity
@Table(name = "M_MemberAircard", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberAircardEntity extends BaseIdEntity{

        /**
        *会员卡号
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *航司ID
        */
        @Basic
        @Column(name = "AirCardType")
        private Byte airCardType;
        /**
        *卡号
        */
        @Basic
        @Column(name = "AirCardNum")
        private String airCardNum;
        /**
        *是否可用
        */
        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;

        public String getCardNum() {
        return this.cardNum;
        }
        public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        }










        public Byte getAirCardType() {
        return this.airCardType;
        }
        public void setAirCardType(Byte airCardType) {
        this.airCardType = airCardType;
        }
        public String getAirCardNum() {
        return this.airCardNum;
        }
        public void setAirCardNum(String airCardNum) {
        this.airCardNum = airCardNum;
        }










        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }

}
