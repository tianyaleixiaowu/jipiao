package com.tianyalei.jipiao.core.model;


import com.tianyalei.jipiao.core.model.base.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

public class TFEntity extends BaseEntity{
    /**
     * 上级单位
     */
    private Integer upCompany;
    /**
     * 转换选择单位
     */
    private List<RegionBeanTree> tFCompany;
    /**
     * 服务费收取方式
     */
    private String serverType;
    /**
     * 适用机票出票政策
     */
    private String policyType;
    /**
     * 短信发送方式
     */
    private String sendMessageType;
    /**
     * 差旅控制方式
     */
    private String travelControlType;
    /**
     * 单位备注
     */
    private String remark;
    /**
     * 服务费收取金额
     */
    private BigDecimal serverCost;
    /**
     * 欠款期限（月）
     */
    private Byte debtTime;
    /**
     * 审批类型
     */
    private String approveType;
    /**
     * 是否允许结算
     */
    private boolean isBalance;
    /**
     * 是否转换部门
     */
    private boolean isTF;

    public Integer getUpCompany() {
        return upCompany;
    }

    public void setUpCompany(Integer upCompany) {
        this.upCompany = upCompany;
    }

    public List<RegionBeanTree> gettFCompany() {
        return tFCompany;
    }

    public void settFCompany(List<RegionBeanTree> tFCompany) {
        this.tFCompany = tFCompany;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getSendMessageType() {
        return sendMessageType;
    }

    public void setSendMessageType(String sendMessageType) {
        this.sendMessageType = sendMessageType;
    }

    public String getTravelControlType() {
        return travelControlType;
    }

    public void setTravelControlType(String travelControlType) {
        this.travelControlType = travelControlType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getServerCost() {
        return serverCost;
    }

    public void setServerCost(BigDecimal serverCost) {
        this.serverCost = serverCost;
    }

    public Byte getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(Byte debtTime) {
        this.debtTime = debtTime;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public boolean isBalance() {
        return isBalance;
    }

    public void setBalance(boolean balance) {
        isBalance = balance;
    }

    public boolean isTF() {
        return isTF;
    }

    public void setIsTF(boolean isTF) {
        this.isTF = isTF;
    }
}
