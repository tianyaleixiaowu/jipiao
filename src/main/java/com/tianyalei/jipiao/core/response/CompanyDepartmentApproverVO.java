package com.tianyalei.jipiao.core.response;

/**
 * @author wuweifeng wrote on 2018/12/6.
 */
public class CompanyDepartmentApproverVO {
    private Integer id;
    private int companyId;
    private int departmentId;
    private String cardNum;
    private String realName;
    private byte approvalSort;
    private boolean isEnable = true;

    private String deptName;

    @Override
    public String toString() {
        return "CompanyDepartmentApproverVO{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", departmentId=" + departmentId +
                ", cardNum='" + cardNum + '\'' +
                ", realName='" + realName + '\'' +
                ", approvalSort=" + approvalSort +
                ", isEnable=" + isEnable +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public byte getApprovalSort() {
        return approvalSort;
    }

    public void setApprovalSort(byte approvalSort) {
        this.approvalSort = approvalSort;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

