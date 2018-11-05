package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberBalanceCompanySetting", catalog = "")
public class MMemberBalanceCompanySettingEntity {
    private int id;
    private String memberBalanceCompanyId;
    private byte rightKey;
    private String cardNum;
    private int companyId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MemberBalanceCompanyID")
    public String getMemberBalanceCompanyId() {
        return memberBalanceCompanyId;
    }

    public void setMemberBalanceCompanyId(String memberBalanceCompanyId) {
        this.memberBalanceCompanyId = memberBalanceCompanyId;
    }

    @Basic
    @Column(name = "RightKey")
    public byte getRightKey() {
        return rightKey;
    }

    public void setRightKey(byte rightKey) {
        this.rightKey = rightKey;
    }

    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MMemberBalanceCompanySettingEntity that = (MMemberBalanceCompanySettingEntity) o;
        return id == that.id &&
                rightKey == that.rightKey &&
                companyId == that.companyId &&
                Objects.equals(memberBalanceCompanyId, that.memberBalanceCompanyId) &&
                Objects.equals(cardNum, that.cardNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, memberBalanceCompanyId, rightKey, cardNum, companyId);
    }
}
