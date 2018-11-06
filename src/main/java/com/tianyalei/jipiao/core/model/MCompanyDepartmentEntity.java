package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_CompanyDepartment", catalog = "")
public class MCompanyDepartmentEntity extends BaseIdEntity {
    private int companyId;
    private String departmentName;
    private boolean isDeptApprove;
    private String approveType;
    private String hrDeptId;
    private boolean isEnable;

    @Override
    public String toString() {
        return "MCompanyDepartmentEntity{" +
                "companyId=" + companyId +
                ", departmentName='" + departmentName + '\'' +
                ", isDeptApprove=" + isDeptApprove +
                ", approveType='" + approveType + '\'' +
                ", hrDeptId='" + hrDeptId + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }

    @Basic
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "DepartmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmenName(String departmentName) {
        this.departmentName = departmentName;
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
