package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_MemberExtend", catalog = "")
public class MMemberExtendEntity {
    private String cardNum;
    private String personnelId;
    private String officeAddress;
    private Timestamp loginTime;
    private String remark;

    @Id
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "PersonnelID")
    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }

    @Basic
    @Column(name = "OfficeAddress")
    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Basic
    @Column(name = "LoginTime")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MMemberExtendEntity that = (MMemberExtendEntity) o;
        return Objects.equals(cardNum, that.cardNum) &&
                Objects.equals(personnelId, that.personnelId) &&
                Objects.equals(officeAddress, that.officeAddress) &&
                Objects.equals(loginTime, that.loginTime) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cardNum, personnelId, officeAddress, loginTime, remark);
    }
}
