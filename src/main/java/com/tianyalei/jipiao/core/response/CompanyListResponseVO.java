package com.tianyalei.jipiao.core.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
public class CompanyListResponseVO {
    private Integer id;
    private String companyName;
    /**
     * 所属板块 groupid 53
     */
    private String panelname;
    /**
     * TODO
     */
    private String panelnameValue;
    /**
     * 适用机票出票政策 GroupID=60
     */
    private String policyType;
    private String policyTypeValue;
    /**
     * 欠款期限（月）
     */
    private Byte debtTime;
    /**
     * 是否可用 ，1可用，0不可用
     */
    private boolean isEnable;
    /**
     * 审批类型 GroupID=61
     */
    private String approveType;
    /**
     * TODO
     */
    private String approveTypeValue;
    /**
     * 差旅控制方式 GroupID=55
     */
    private String travelControlType;
    /**
     * TODO
     */
    private String travelControlTypeValue;
    /**
     * 是否允许结算
     */
    private boolean isBalance;
    /**
     * 服务费收取方式 GroupID=58
     */
    private String serverType;
    /**
     * TODO
     */
    private String serverTypeValue;
    /**
     * 服务费收取金额
     */
    private BigDecimal serverCost;

    private String createRealName;
    private Timestamp createTime;
    private Timestamp updateTime;

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyTypeValue() {
        return policyTypeValue;
    }

    public void setPolicyTypeValue(String policyTypeValue) {
        this.policyTypeValue = policyTypeValue;
    }

    public Byte getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(Byte debtTime) {
        this.debtTime = debtTime;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPanelname() {
        return panelname;
    }

    public void setPanelname(String panelname) {
        this.panelname = panelname;
    }

    public String getPanelnameValue() {
        return panelnameValue;
    }

    public void setPanelnameValue(String panelnameValue) {
        this.panelnameValue = panelnameValue;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public String getApproveTypeValue() {
        return approveTypeValue;
    }

    public void setApproveTypeValue(String approveTypeValue) {
        this.approveTypeValue = approveTypeValue;
    }

    public String getTravelControlType() {
        return travelControlType;
    }

    public void setTravelControlType(String travelControlType) {
        this.travelControlType = travelControlType;
    }

    public String getTravelControlTypeValue() {
        return travelControlTypeValue;
    }

    public void setTravelControlTypeValue(String travelControlTypeValue) {
        this.travelControlTypeValue = travelControlTypeValue;
    }

    public boolean getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(boolean balance) {
        isBalance = balance;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getServerTypeValue() {
        return serverTypeValue;
    }

    public void setServerTypeValue(String serverTypeValue) {
        this.serverTypeValue = serverTypeValue;
    }

    public BigDecimal getServerCost() {
        return serverCost;
    }

    public void setServerCost(BigDecimal serverCost) {
        this.serverCost = serverCost;
    }

    public String getCreateRealName() {
        return createRealName;
    }

    public void setCreateRealName(String createRealName) {
        this.createRealName = createRealName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
