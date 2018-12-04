package com.tianyalei.jipiao.core.request;

import javax.validation.constraints.NotEmpty;

/**
 * @author wuweifeng wrote on 2018/11/6.
 */
public class MemberAddRequestModel {
    private String cardNum;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 会员类型（数据字典 GroupId=7）
     */
    private String memberType;
    /**
     * 会员所属单位
     */
    private Integer companyId;
    /**
     * 部门ID
     */
    private Integer departmentId;
    /**
     * 差旅等级ID
     */
    private Integer travelLevelId;
    /**
     * 性别（1为男，0为女)
     */
    private byte gender;
    /**
     * 人员类型 groupId=54
     */
    private String personnelType;
    /**
     * 会员等级（数据字典 GroupId=41）
     */
    private String memberClass;
    /**
     * 职务 GroupID=49
     */
    private String position;
    /**
     * 职称 GroupID=50
     */
    private String jobTitle;
    /**
     * 行政级别（GroupID=31）
     */
    private String administrativeLevel;
    /**
     * 乘机人姓名（航信系统使用，生僻字用拼音代替
     */
    private String passengerName;
    /**
     * 读取M_HTCountry表，数据存储CountryCode字段内容
     */
    @NotEmpty(message = "国家不能为空")
    private String country;
    /**
     * 民族 GroupID=8
     */
    private String nation;
    /**
     * 手机号码 //TODO
     */
    private String cellPhone;
    /**
     * 备用手机（密文）//TODO
     */
    private String backupCellPhone;
    /**
     * 家庭电话
     */
    private String phoneNum;
    /**
     * 证件号码（密文）//TODO
     */
    private String paperNum;
    //TODO
    private String birthday;
    private String email;
    /**
     * 本人是否为领导秘书，0不是，1是
     */
    private String isSecretary;
    /**
     * HR人员编号
     */
    private String hrCode;
    /**
     * 备注，TODO  表 M_MemberExtend
     */
    private String remark;
    /**
     * 创建用户的票台ID
     */
    private int ticketOfficeId;
    /**
     * 是否可用
     */
    private boolean isEnable = false;

    @Override
    public String toString() {
        return "MemberAddRequestModel{" +
                "cardNum='" + cardNum + '\'' +
                ", realName='" + realName + '\'' +
                ", memberType='" + memberType + '\'' +
                ", companyId=" + companyId +
                ", departmentId=" + departmentId +
                ", travelLevelId=" + travelLevelId +
                ", gender=" + gender +
                ", personnelType='" + personnelType + '\'' +
                ", memberClass='" + memberClass + '\'' +
                ", position='" + position + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", administrativeLevel='" + administrativeLevel + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", country='" + country + '\'' +
                ", nation='" + nation + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", backupCellPhone='" + backupCellPhone + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", paperNum='" + paperNum + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", isSecretary='" + isSecretary + '\'' +
                ", hrCode='" + hrCode + '\'' +
                ", remark='" + remark + '\'' +
                ", ticketOfficeId=" + ticketOfficeId +
                ", isEnable=" + isEnable +
                '}';
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
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

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    public String getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(String memberClass) {
        this.memberClass = memberClass;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getBackupCellPhone() {
        return backupCellPhone;
    }

    public void setBackupCellPhone(String backupCellPhone) {
        this.backupCellPhone = backupCellPhone;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsSecretary() {
        return isSecretary;
    }

    public void setIsSecretary(String isSecretary) {
        this.isSecretary = isSecretary;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTravelLevelId() {
        return travelLevelId;
    }

    public void setTravelLevelId(Integer travelLevelId) {
        this.travelLevelId = travelLevelId;
    }

    public int getTicketOfficeId() {
        return ticketOfficeId;
    }

    public void setTicketOfficeId(int ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }
}
