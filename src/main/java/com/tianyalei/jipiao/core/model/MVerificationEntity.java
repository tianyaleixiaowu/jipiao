package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_Verification", catalog = "")
public class MVerificationEntity {
    private int id;
    private String randomCode;
    private String verificationType;
    private String phoneOrEmail;
    private int validDuration;
    private byte isUse;
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
    @Column(name = "RandomCode")
    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    @Basic
    @Column(name = "VerificationType")
    public String getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(String verificationType) {
        this.verificationType = verificationType;
    }

    @Basic
    @Column(name = "PhoneOrEmail")
    public String getPhoneOrEmail() {
        return phoneOrEmail;
    }

    public void setPhoneOrEmail(String phoneOrEmail) {
        this.phoneOrEmail = phoneOrEmail;
    }

    @Basic
    @Column(name = "ValidDuration")
    public int getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(int validDuration) {
        this.validDuration = validDuration;
    }

    @Basic
    @Column(name = "IsUse")
    public byte getIsUse() {
        return isUse;
    }

    public void setIsUse(byte isUse) {
        this.isUse = isUse;
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
        MVerificationEntity that = (MVerificationEntity) o;
        return id == that.id &&
                validDuration == that.validDuration &&
                isUse == that.isUse &&
                Objects.equals(randomCode, that.randomCode) &&
                Objects.equals(verificationType, that.verificationType) &&
                Objects.equals(phoneOrEmail, that.phoneOrEmail) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, randomCode, verificationType, phoneOrEmail, validDuration, isUse, createTime);
    }
}
