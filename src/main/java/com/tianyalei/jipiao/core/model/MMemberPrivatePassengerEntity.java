package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* 会员（因私出行）常用乘机人表
* @author Bai
* @date 2019/01/07 11:38
*/
@Entity
@Table(name = "M_MemberPrivatePassenger", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberPrivatePassengerEntity extends BaseIdEntity{

        /**
        *会员卡号
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *姓名
        */
        @Basic
        @Column(name = "PassengerName")
        private String passengerName;
        /**
        *性别 1男 0 女
        */
        @Basic
        @Column(name = "Gender")
        private Byte gender;
        /**
        *身份证号
        */
        @Basic
        @Column(name = "PaperNum")
        private String paperNum;
        /**
        *护照号码
        */
        @Basic
        @Column(name = "PassportNo")
        private String passportNo;
        /**
        *是否有效
        */
        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;
        /**
        *手机号码
        */
        @Basic
        @Column(name = "CellPhone")
        private String cellPhone;

        public String getCardNum() {
        return this.cardNum;
        }
        public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        }





        public String getPassengerName() {
        return this.passengerName;
        }
        public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
        }










        public Byte getGender() {
        return this.gender;
        }
        public void setGender(Byte gender) {
        this.gender = gender;
        }
        public String getPaperNum() {
        return this.paperNum;
        }
        public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
        }





        public String getPassportNo() {
        return this.passportNo;
        }
        public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
        }










        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }
        public String getCellPhone() {
        return this.cellPhone;
        }
        public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        }










}
