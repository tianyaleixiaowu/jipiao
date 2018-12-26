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
@Table(name = "M_HREmployee", catalog = "")
public class MHrEmployeeEntity extends BaseEntity {
    @ExcelColumn(value = "员工编号", col = 1)
    private String employeeId;
    @ExcelColumn(value = "真实姓名", col = 2)
    private String realName;
    @ExcelColumn(value = "性别", col = 3)
    private String gender;
    @ExcelColumn(value = "员工类型", col = 4)
    private String employeeType;
    @ExcelColumn(value = "传真号码", col = 5)
    private String faxNum;
    @ExcelColumn(value = "邮件", col = 6)
    private String email;
    @ExcelColumn(value = "证件号码", col = 7)
    private String paperNum;
    @ExcelColumn(value = "电话号码", col = 8)
    private String phoneNum;
    @ExcelColumn(value = "职务", col = 9)
    private String position;
    @ExcelColumn(value = "职称", col = 10)
    private String jobTitle;
    @ExcelColumn(value = "HR人员编号", col = 11)
    private String hrCode;
    private String administrativeLevel;

    private boolean isEnable = true;
    private String impFlag = UUID.randomUUID().toString();
    private Byte travelLevel;

    @Id
    @Column(name = "EmployeeID")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "RealName")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "EmployeeType")
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Basic
    @Column(name = "FaxNum")
    public String getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PaperNum")
    public String getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
    }

    @Basic
    @Column(name = "PhoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "Position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "JobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "HRCode")
    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
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

    @Basic
    @Column(name = "TravelLevel")
    public Byte getTravelLevel() {
        return travelLevel;
    }

    public void setTravelLevel(Byte travelLevel) {
        this.travelLevel = travelLevel;
    }

    @Basic
    @Column(name = "AdministrativeLevel")
    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MHrEmployeeEntity that = (MHrEmployeeEntity) o;
        return isEnable == that.isEnable &&
                Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(realName, that.realName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(employeeType, that.employeeType) &&
                Objects.equals(faxNum, that.faxNum) &&
                Objects.equals(email, that.email) &&
                Objects.equals(paperNum, that.paperNum) &&
                Objects.equals(phoneNum, that.phoneNum) &&
                Objects.equals(position, that.position) &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(hrCode, that.hrCode) &&
                Objects.equals(impFlag, that.impFlag) &&
                Objects.equals(travelLevel, that.travelLevel);
    }

}
