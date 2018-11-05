package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyDepartment", catalog = "")
public class MCompanyDepartmentEntity extends BaseEntity {
    private int companyId;
    private String departmenName;
    private boolean isDeptApprove;
    private String approveType;
    private String hrDeptId;
    private boolean isEnable;


    @Basic
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "DepartmenName")
    public String getDepartmenName() {
        return departmenName;
    }

    public void setDepartmenName(String departmenName) {
        this.departmenName = departmenName;
    }

    @Basic
    @Column(name = "IsDeptApprove")
    public boolean isDeptApprove() {
        return isDeptApprove;
    }

    public void setDeptApprove(boolean deptApprove) {
        isDeptApprove = deptApprove;
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
    @Column(name = "HRDeptID")
    public String getHrDeptId() {
        return hrDeptId;
    }

    public void setHrDeptId(String hrDeptId) {
        this.hrDeptId = hrDeptId;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
