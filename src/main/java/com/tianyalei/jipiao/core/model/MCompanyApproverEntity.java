package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 单位审批人表
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyApprover", catalog = "")
public class MCompanyApproverEntity extends BaseIdEntity {
    private int companyId;
    private String cardNum;
    /**
     * 会员姓名
     */
    private String realName;
    /**
     * 审批顺序
     */
    private byte approvalSort;
    /**
     * 是否可用
     */
    private boolean isEnable = true;

    @Basic
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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
