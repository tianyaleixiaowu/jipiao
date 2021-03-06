package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyDepartmentApprover", catalog = "")
public class MCompanyDepartmentApproverEntity extends BaseIdEntity {
    private int companyId;
    private int departmentId;
    private String cardNum;
    private String realName;
    private byte approvalSort;
    private boolean isEnable = true;

    @Override
    public String toString() {
        return "MCompanyDepartmentApproverEntity{" +
                "companyId=" + companyId +
                ", departmentId=" + departmentId +
                ", cardNum='" + cardNum + '\'' +
                ", realName='" + realName + '\'' +
                ", approvalSort=" + approvalSort +
                ", isEnable=" + isEnable +
                '}';
    }

    @Basic
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "DepartmentID")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
    @Column(name = "RealName")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "ApprovalSort")
    public byte getApprovalSort() {
        return approvalSort;
    }

    public void setApprovalSort(byte approvalSort) {
        this.approvalSort = approvalSort;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

}
