package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.*;


/**
* 会员（因公出行）常用乘机人表
* @author Bai
* @date 2019/01/07 11:38
*/
@Entity
@Table(name = "M_MemberPassenger", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","mMemberEntity"})
public class MMemberPassengerEntity extends BaseIdEntity{

        /**
        *会员卡号
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *乘机人卡号
        */
        @Basic
        @Column(name = "PassengerCardNum")
        private String passengerCardNum;

        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;
        /**
         * 乘机人姓名
         */
        @Transient
        private String cardNumName;

        public String getCardNumName() {
                return cardNumName;
        }

        public void setCardNumName(String cardNumName) {
                this.cardNumName = cardNumName;
        }

        @OneToOne(cascade={CascadeType.ALL})
        @JoinColumn(name = "passengerCardNum")
        private MMemberEntity mMemberEntity;

        public MMemberEntity getmMemberEntity() {
                return mMemberEntity;
        }

        public void setmMemberEntity(MMemberEntity mMemberEntity) {
                this.mMemberEntity = mMemberEntity;
        }

        public String getCardNum() {
        return this.cardNum;
        }
        public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        }


        public boolean getIsEnable() {
                return isEnable;
        }

        public void setIsEnable(boolean enable) {
                isEnable = enable;
        }

        public String getPassengerCardNum() {
        return this.passengerCardNum;
        }
        public void setPassengerCardNum(String passengerCardNum) {
        this.passengerCardNum = passengerCardNum;
        }






}
