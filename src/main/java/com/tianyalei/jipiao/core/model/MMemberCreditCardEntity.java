package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
* 会员信用卡表
* @author Bai
* @date 2019/01/07 11:08
*/
@Entity
@Table(name = "M_MemberCreditCard", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberCreditCardEntity extends BaseIdEntity{

        /**
        *会员卡号
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *信用卡号
        */
        @Basic
        @Column(name = "CreditCardNo")
        private String creditCardNo;
        /**
        *银行(groupid=19)
        */
        @Basic
        @Column(name = "Bank")
        private Byte bank;
        /**
        *有效期
        */
        @Basic
        @Column(name = "Valid")
        private Date valid;
        /**
        *验证码
        */
        @Basic
        @Column(name = "Verification")
        private String verification;
        /**
        *持卡人姓名
        */
        @Basic
        @Column(name = "PersonName")
        private String personName;
        /**
        *持卡人证件号码
        */
        @Basic
        @Column(name = "PaperCode")
        private String paperCode;
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





        public String getCreditCardNo() {
        return this.creditCardNo;
        }
        public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
        }










        public Byte getBank() {
        return this.bank;
        }
        public void setBank(Byte bank) {
        this.bank = bank;
        }

        public Date getValid() {
        return this.valid;
        }
        public void setValid(Date valid) {
        this.valid = valid;
        }




        public String getVerification() {
        return this.verification;
        }
        public void setVerification(String verification) {
        this.verification = verification;
        }





        public String getPersonName() {
        return this.personName;
        }
        public void setPersonName(String personName) {
        this.personName = personName;
        }





        public String getPaperCode() {
        return this.paperCode;
        }
        public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
        }









        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }


}
