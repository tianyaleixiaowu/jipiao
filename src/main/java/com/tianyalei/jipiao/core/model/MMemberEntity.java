package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_Member", catalog = "")
public class MMemberEntity extends BaseEntity {
    private String cardNum;
    /**
     * 真实姓名
     */
    private String realName;
    private String userPwd;
    /**
     * 性别（1为男，0为女)
     */
    private byte gender;
    private String country;
    /**
     * 会员类型（数据字典 GroupId=7）
     */
    private String memberType;
    /**
     * 会员等级（数据字典 GroupId=9）
     */
    private String memberClass;
    /**
     * 民族
     */
    private String nation;
    private String email;
    /**
     *  证件号码（密文）
     */
    private String paperNum;
    /**
     * 手机号码（密文）
     */
    private String cellPhone;
    /**
     *  备用手机（密文）
     */
    private String backupCellPhone;
    /**
     * 办公电话
     */
    private String officePhone;
    /**
     * 家庭电话
     */
    private String homePhone;
    private Timestamp birthday;
    /**
     * 职务
     */
    private String position;
    /**
     * 乘机人姓名（航信系统使用，生僻字用拼音代替
     */
    private String passengerName;
    /**
     * 行政级别（GroupID=31）
     */
    private String administrativeLevel;
    /**
     * 职称
     */
    private String jobTitle;
    /**
     * 本人是否为领导秘书
     */
    private String isSecretary;
    /**
     * 会员所属单位
     */
    private Integer companyId;
    /**
     * 部门ID
     */
    private Integer departmentId;
    /**
     * 人员类型
     */
    private String personnelType;
    /**
     * 会员来源（GroupID=42）
     */
    private String memberFrom;
    /**
     * HR人员编号
     */
    private String hrCode;
    /**
     * 是否可用
     */
    private boolean isEnable;
    /**
     * 创建用户的票台ID
     */
    private int ticketOfficeId;

    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
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
    @Column(name = "UserPwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "Gender")
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "MemberClass")
    public String getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(String memberClass) {
        this.memberClass = memberClass;
    }

    @Basic
    @Column(name = "MemberType")
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Basic
    @Column(name = "Nation")
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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
    @Column(name = "CellPhone")
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Basic
    @Column(name = "BackupCellPhone")
    public String getBackupCellPhone() {
        return backupCellPhone;
    }

    public void setBackupCellPhone(String backupCellPhone) {
        this.backupCellPhone = backupCellPhone;
    }

    @Basic
    @Column(name = "OfficePhone")
    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    @Basic
    @Column(name = "HomePhone")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "Birthday")
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
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
    @Column(name = "PassengerName")
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Basic
    @Column(name = "AdministrativeLevel")
    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
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
    @Column(name = "IsSecretary")
    public String getIsSecretary() {
        return isSecretary;
    }

    public void setIsSecretary(String isSecretary) {
        this.isSecretary = isSecretary;
    }

    @Basic
    @Column(name = "CompanyID")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "DepartmentID")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "PersonnelType")
    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    @Basic
    @Column(name = "MemberFrom")
    public String getMemberFrom() {
        return memberFrom;
    }

    public void setMemberFrom(String memberFrom) {
        this.memberFrom = memberFrom;
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
    @Column(name = "TicketOfficeID")
    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }
}
