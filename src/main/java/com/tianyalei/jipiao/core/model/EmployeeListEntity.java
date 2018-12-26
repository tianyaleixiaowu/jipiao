package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import java.util.List;

/**
 * 分页数据使用实体
 */
public class EmployeeListEntity extends BaseEntity{
    private String employeeId;
    private String realName;
    private String orgName;
    private String depName;
    private String paperNum;
    private String phoneNum;
    private String position;
    private String administrativeLevel;
    private Byte travelLevel;
    private String hrCode;
    private String remark;//备注
    private List<String> empList;//转换人员id
    private Integer companyID;//所属单位id

    public EmployeeListEntity(){}

    public EmployeeListEntity(String employeeId,String realName,String hrCode,String paperNum,String phoneNum,Byte travelLevel){
        this.employeeId = employeeId;
        this.realName = realName;
        this.hrCode = hrCode;
        this.paperNum = paperNum;
        this.phoneNum = phoneNum;
        this.travelLevel = travelLevel;
    }

    public EmployeeListEntity(String employeeId, String realName, String orgName, String depName, String paperNum, String phoneNum, String position, String administrativeLevel, Byte travelLevel) {
        this.employeeId = employeeId;
        this.realName = realName;
        this.orgName = orgName;
        this.depName = depName;
        this.paperNum = paperNum;
        this.phoneNum = phoneNum;
        this.position = position;
        this.administrativeLevel = administrativeLevel;
        this.travelLevel = travelLevel;
    }

    public List<String> getEmpList() {
        return empList;
    }

    public void setEmpList(List<String> empList) {
        this.empList = empList;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
    }

    public Byte getTravelLevel() {
        return travelLevel;
    }

    public void setTravelLevel(Byte travelLevel) {
        this.travelLevel = travelLevel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}