package com.tianyalei.jipiao.core.request;

import java.math.BigDecimal;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
public class CompanyAddRequestModel {
    private Integer id;
    private String companyName;
    /**
     * 上级单位ID
     */
    private String parentId;
    private String pinYin;
    /**
     * 单位简称
     */
    private String simpleName;
    /**
     * 所属板块groupid 53
     */
    private String panelname;
    /**
     * 电话
     */
    private String telphone;
    private String fax;
    private String address;
    /**
     * 是否可用 ，1可用，0不可用
     */
    private boolean isEnable;
    /**
     * 服务费收取方式GroupID=58
     */
    private String serverType;
    /**
     * 服务费收取金额
     */
    private BigDecimal serverCost;
    /**
     * 适用机票出票政策  GroupID=60
     */
    private String policyType;
    /**
     * 欠款期限（月）
     */
    private Byte debtTime;
    /**
     * 短信发送方式 GroupID=59
     */
    private String sendMessageType;
    /**
     * 是否允许结算
     */
    private boolean isBalance;
    /**
     * 审批类型 GroupID=61
     */
    private String approveType;
    /**
     * 差旅控制方式 GroupID=55
     */
    private String travelControlType;
    /**
     * 企业备注
     */
    private String remark;
    /**
     * 单位等级 TODO
     */
    //private Byte level;

    @Override
    public String toString() {
        return "CompanyAddRequestModel{" +
                "id='" + id + '\'' +
                "companyName='" + companyName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", pinYin='" + pinYin + '\'' +
                ", simpleName='" + simpleName + '\'' +
                ", panelname='" + panelname + '\'' +
                ", telphone='" + telphone + '\'' +
                ", fax='" + fax + '\'' +
                ", address='" + address + '\'' +
                ", isEnable=" + isEnable +
                ", serverType='" + serverType + '\'' +
                ", serverCost=" + serverCost +
                ", policyType='" + policyType + '\'' +
                ", debtTime=" + debtTime +
                ", sendMessageType='" + sendMessageType + '\'' +
                ", isBalance=" + isBalance +
                ", approveType='" + approveType + '\'' +
                ", travelControlType='" + travelControlType + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getPanelname() {
        return panelname;
    }

    public void setPanelname(String panelname) {
        this.panelname = panelname;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getServerCost() {
        return serverCost;
    }

    public void setServerCost(BigDecimal serverCost) {
        this.serverCost = serverCost;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Byte getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(Byte debtTime) {
        this.debtTime = debtTime;
    }

    public String getSendMessageType() {
        return sendMessageType;
    }

    public void setSendMessageType(String sendMessageType) {
        this.sendMessageType = sendMessageType;
    }

    public boolean getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(boolean balance) {
        isBalance = balance;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
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
}
