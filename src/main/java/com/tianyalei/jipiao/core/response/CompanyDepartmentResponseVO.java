package com.tianyalei.jipiao.core.response;

/**
 * @author wuweifeng wrote on 2018/12/6.
 */
public class CompanyDepartmentResponseVO {
    private Long id;
    private int companyId;
    private String departmentName;
    private boolean isDeptApprove;
    /**
     * groupId=61
     */
    private String approveType;
    private String approveTypeValue;

    private String hrDeptId = "";
    private boolean isEnable = true;

    public String getApproveTypeValue() {
        return approveTypeValue;
    }

    public void setApproveTypeValue(String approveTypeValue) {
        this.approveTypeValue = approveTypeValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean getIsDeptApprove() {
        return isDeptApprove;
    }

    public void setIsDeptApprove(boolean deptApprove) {
        isDeptApprove = deptApprove;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public String getHrDeptId() {
        return hrDeptId;
    }

    public void setHrDeptId(String hrDeptId) {
        this.hrDeptId = hrDeptId;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }
}
