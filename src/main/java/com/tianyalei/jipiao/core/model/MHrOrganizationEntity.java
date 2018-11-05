package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_HROrganization", catalog = "")
public class MHrOrganizationEntity extends BaseEntity {
    private String orgId;
    private Byte level;
    private String orgName;
    private String status;
    private String accountCode;
    private String dutyCenterId;
    private String dutyCenterName;
    private String capitalUnit;
    private String capitalUnitName;
    private String budgetUnit;
    private String budgetUnitName;
    private String panelname;
    private String currency;
    private Boolean isEnable;
    private String remark;
    private String impFlag;

    @Column(name = "OrgID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
    @Column(name = "OrgName")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "AccountCode")
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @Basic
    @Column(name = "DutyCenterID")
    public String getDutyCenterId() {
        return dutyCenterId;
    }

    public void setDutyCenterId(String dutyCenterId) {
        this.dutyCenterId = dutyCenterId;
    }

    @Basic
    @Column(name = "DutyCenterName")
    public String getDutyCenterName() {
        return dutyCenterName;
    }

    public void setDutyCenterName(String dutyCenterName) {
        this.dutyCenterName = dutyCenterName;
    }

    @Basic
    @Column(name = "CapitalUnit")
    public String getCapitalUnit() {
        return capitalUnit;
    }

    public void setCapitalUnit(String capitalUnit) {
        this.capitalUnit = capitalUnit;
    }

    @Basic
    @Column(name = "CapitalUnitName")
    public String getCapitalUnitName() {
        return capitalUnitName;
    }

    public void setCapitalUnitName(String capitalUnitName) {
        this.capitalUnitName = capitalUnitName;
    }

    @Basic
    @Column(name = "BudgetUnit")
    public String getBudgetUnit() {
        return budgetUnit;
    }

    public void setBudgetUnit(String budgetUnit) {
        this.budgetUnit = budgetUnit;
    }

    @Basic
    @Column(name = "BudgetUnitName")
    public String getBudgetUnitName() {
        return budgetUnitName;
    }

    public void setBudgetUnitName(String budgetUnitName) {
        this.budgetUnitName = budgetUnitName;
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
    @Column(name = "Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "IsEnable")
    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
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
    @Column(name = "ImpFlag")
    public String getImpFlag() {
        return impFlag;
    }

    public void setImpFlag(String impFlag) {
        this.impFlag = impFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MHrOrganizationEntity that = (MHrOrganizationEntity) o;
        return Objects.equals(orgId, that.orgId) &&
                Objects.equals(level, that.level) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(status, that.status) &&
                Objects.equals(accountCode, that.accountCode) &&
                Objects.equals(dutyCenterId, that.dutyCenterId) &&
                Objects.equals(dutyCenterName, that.dutyCenterName) &&
                Objects.equals(capitalUnit, that.capitalUnit) &&
                Objects.equals(capitalUnitName, that.capitalUnitName) &&
                Objects.equals(budgetUnit, that.budgetUnit) &&
                Objects.equals(budgetUnitName, that.budgetUnitName) &&
                Objects.equals(panelname, that.panelname) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(isEnable, that.isEnable) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(impFlag, that.impFlag);
    }

}
