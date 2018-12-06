package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;
import com.tianyalei.jipiao.global.excel.ExcelColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_HRDepartment", catalog = "")
public class MHrDepartmentEntity extends BaseEntity implements Serializable {
    @ExcelColumn(value = "部门ID", col = 1)
    private String depId;
    @ExcelColumn(value = "部门名称", col = 2)
    private String depName;
    @ExcelColumn(value = "部门等级", col=3)
    private Byte depLevel;
    @ExcelColumn(value = "组织结构ID", col=4)
    private String orgId;
    @ExcelColumn(value = "组织结构名称", col=5)
    private String orgName;
    @ExcelColumn(value = "使用状态", col=6)
    private String useStatus;
    @ExcelColumn(value = "资金单位ID", col=7)
    private String capitalDep;
    @ExcelColumn(value = "资金单位名称", col=8)
    private String capitalDepName;

    private boolean isEnable = true;
    private String impFlag = UUID.randomUUID().toString();

    @Id
    @Column(name = "DepID")
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "DepName")
    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Basic
    @Column(name = "DepLevel")
    public Byte getDepLevel() {
        return depLevel;
    }

    public void setDepLevel(Byte depLevel) {
        this.depLevel = depLevel;
    }

    @Basic
    @Column(name = "OrgID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
    @Column(name = "UseStatus")
    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    @Basic
    @Column(name = "CapitalDep")
    public String getCapitalDep() {
        return capitalDep;
    }

    public void setCapitalDep(String capitalDep) {
        this.capitalDep = capitalDep;
    }

    @Basic
    @Column(name = "CapitalDepName")
    public String getCapitalDepName() {
        return capitalDepName;
    }

    public void setCapitalDepName(String capitalDepName) {
        this.capitalDepName = capitalDepName;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

    @Basic
    @Column(name = "ImpFlag")
    public String getImpFlag() {
        return impFlag;
    }

    public void setImpFlag(String impFlag) {
        this.impFlag = impFlag;
    }

}
