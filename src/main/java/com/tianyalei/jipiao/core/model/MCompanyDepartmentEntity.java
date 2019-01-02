package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;
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
    /**
     * groupId=61
     */
    private String approveType;
    private String hrDeptId = " ";//防止数据库报null加空格,查询时''即可
    private boolean isEnable = true;

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

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    @Basic
    @Column(name = "IsDeptApprove")
    public boolean getIsDeptApprove() {
        return isDeptApprove;
    }

    public void setIsDeptApprove(boolean deptApprove) {
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
    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }
}
