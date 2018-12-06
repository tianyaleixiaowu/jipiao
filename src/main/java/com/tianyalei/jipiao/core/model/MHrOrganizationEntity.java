package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;
import com.tianyalei.jipiao.global.excel.ExcelColumn;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_HROrganization", catalog = "")
public class MHrOrganizationEntity extends BaseEntity {
    @ExcelColumn(value = "组织结构ID", col = 1)
    private String orgId;
    @ExcelColumn(value = "单位等级", col = 2)
    private Byte level;
    @ExcelColumn(value = "组织结构名称", col = 3)
    private String orgName;
    @ExcelColumn(value = "使用状态", col = 4)
    private String status;
    @ExcelColumn(value = "账号编码", col = 5)
    private String accountCode;
    @ExcelColumn(value = "责任中心ID", col = 6)
    private String dutyCenterId;
    @ExcelColumn(value = "责任中心名称", col = 7)
    private String dutyCenterName;
    @ExcelColumn(value = "资金单位ID", col = 8)
    private String capitalUnit;
    @ExcelColumn(value = "资金单位名称", col = 9)
    private String capitalUnitName;
    @ExcelColumn(value = "预算单位ID", col = 10)
    private String budgetUnit;
    @ExcelColumn(value = "资金单位名称", col = 11)
    private String budgetUnitName;
    @ExcelColumn(value = "所属板块", col = 12)
    private String panelname;
    @ExcelColumn(value = "币种", col = 13)
    private String currency;

    private Boolean isEnable = true;
    private String remark;
    private String impFlag = UUID.randomUUID().toString();

    @Id
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
    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean enable) {
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
