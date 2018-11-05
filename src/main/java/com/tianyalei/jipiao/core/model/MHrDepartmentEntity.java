package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.*;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_HRDepartment", catalog = "")
public class MHrDepartmentEntity extends BaseEntity {
    private String depId;
    private String depName;
    private Byte depLevel;
    private String orgId;
    private String orgName;
    private String useStatus;
    private String capitalDep;
    private String capitalDepName;
    private boolean isEnable;
    private String impFlag;

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
    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
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
