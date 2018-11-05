package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 单位信息表
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_Company", catalog = "")
public class MCompanyEntity extends BaseEntity {
    private String companyName;
    /**
     * 单位简称
     */
    private String simpleName;
    /**
     * 上级单位ID
     */
    private String parentId;
    private String pinYin;
    /**
     * 电话
     */
    private String telphone;
    private String fax;
    private String address;
    /**
     * 可用积分
     */
    private int availScore;
    /**
     * 总积分
     */
    private int totScore;
    /**
     * 企业备注
     */
    private String remark;
    /**
     * 单位等级
     */
    private Byte level;
    /**
     * 服务费收取方式
     */
    private String serverType;
    /**
     * 服务费收取金额
     */
    private BigDecimal serverCost;
    /**
     * 短信发送方式
     */
    private String sendMessageType;
    /**
     * 适用机票出票政策
     */
    private String policyType;
    /**
     * 欠款期限（月）
     */
    private Byte debtTime;
    /**
     * 所属板块
     */
    private String panelname;
    /**
     * 是否允许结算
     */
    private boolean isBalance;
    /**
     * 是否可用
     */
    private boolean isEnable;
    /**
     * 审批类型
     */
    private String approveType;
    /**
     * 差旅控制方式
     */
    private String travelControlType;
    /**
     * HR系统-组织结构ID
     */
    private String hrOrgId;


    @Basic
    @Column(name = "CompanyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "SimpleName")
    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    @Basic
    @Column(name = "ParentID")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "PinYin")
    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    @Basic
    @Column(name = "Telphone")
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "Fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "AvailScore")
    public int getAvailScore() {
        return availScore;
    }

    public void setAvailScore(int availScore) {
        this.availScore = availScore;
    }

    @Basic
    @Column(name = "TotScore")
    public int getTotScore() {
        return totScore;
    }

    public void setTotScore(int totScore) {
        this.totScore = totScore;
    }

    @Basic
    @Column(name = "Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "Level")
    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "ServerType")
    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    @Basic
    @Column(name = "ServerCost")
    public BigDecimal getServerCost() {
        return serverCost;
    }

    public void setServerCost(BigDecimal serverCost) {
        this.serverCost = serverCost;
    }

    @Basic
    @Column(name = "SendMessageType")
    public String getSendMessageType() {
        return sendMessageType;
    }

    public void setSendMessageType(String sendMessageType) {
        this.sendMessageType = sendMessageType;
    }

    @Basic
    @Column(name = "PolicyType")
    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    @Basic
    @Column(name = "DebtTime")
    public Byte getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(Byte debtTime) {
        this.debtTime = debtTime;
    }

    @Basic
    @Column(name = "Panelname")
    public String getPanelname() {
        return panelname;
    }

    public void setPanelname(String panelname) {
        this.panelname = panelname;
    }

    @Basic
    @Column(name = "IsBalance")
    public boolean isBalance() {
        return isBalance;
    }

    public void setBalance(boolean balance) {
        isBalance = balance;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Basic
    @Column(name = "ApproveType")
    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    @Basic
    @Column(name = "TravelControlType")
    public String getTravelControlType() {
        return travelControlType;
    }

    public void setTravelControlType(String travelControlType) {
        this.travelControlType = travelControlType;
    }


    @Basic
    @Column(name = "HROrgID")
    public String getHrOrgId() {
        return hrOrgId;
    }

    public void setHrOrgId(String hrOrgId) {
        this.hrOrgId = hrOrgId;
    }

}
