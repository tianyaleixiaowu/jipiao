package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Objects;

/**
 * 会员信用卡表
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberCreditCard", catalog = "")
public class MMemberCreditCardEntity extends BaseEntity {
    /**
     * 会员卡号
     */
    private String cardNum;
    /**
     * 信用卡号
     */
    private String creditCardNo;
    /**
     * 开户银行
     */
    private byte bank;
    /**
     * 有效期
     */
    private String valid;
    /**
     * 验证码，CVV码
     */
    private String verification;
    /**
     * 持卡人姓名
     */
    private String personName;
    /**
     * 持卡人证件号码
     */
    private String paperCode;

    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "CreditCardNo")
    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Basic
    @Column(name = "Bank")
    public byte getBank() {
        return bank;
    }

    public void setBank(byte bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "Valid")
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "Verification")
    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    @Basic
    @Column(name = "PersonName")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Basic
    @Column(name = "PaperCode")
    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MMemberCreditCardEntity that = (MMemberCreditCardEntity) o;
        return
                bank == that.bank &&
                Objects.equals(cardNum, that.cardNum) &&
                Objects.equals(creditCardNo, that.creditCardNo) &&
                Objects.equals(valid, that.valid) &&
                Objects.equals(verification, that.verification) &&
                Objects.equals(personName, that.personName) &&
                Objects.equals(paperCode, that.paperCode) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash( cardNum, creditCardNo, bank, valid, verification, personName, paperCode);
    }
}
