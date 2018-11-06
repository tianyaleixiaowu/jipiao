package com.tianyalei.jipiao.core.response;

/**
 * @author wuweifeng wrote on 2018/11/6.
 */
public class MemberVO {
    private String cardNum;
    /**
     * 会员类型（数据字典 GroupId=7）
     */
    private String memberType;
    private String memberTypeValue;
    /**
     * 性别（1为男，0为女)
     */
    private byte gender;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 会员所属单位
     */
    private Integer companyId;
    /**
     * 公司名字
     */
    private String companyIdValue;
    /**
     * 手机号码（明文）
     */
    private String cellPhone;
    /**
     * 职务 GroupID=49
     */
    private String position;
    private String positionValue;
    /**
     * 行政级别（GroupID=31）
     */
    private String administrativeLevel;
    private String administrativeLevelValue;

    @Override
    public String toString() {
        return "MemberVO{" +
                "cardNum='" + cardNum + '\'' +
                ", memberType='" + memberType + '\'' +
                ", memberTypeValue='" + memberTypeValue + '\'' +
                ", gender=" + gender +
                ", realName='" + realName + '\'' +
                ", companyId=" + companyId +
                ", companyIdValue='" + companyIdValue + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", position='" + position + '\'' +
                ", positionValue='" + positionValue + '\'' +
                ", administrativeLevel='" + administrativeLevel + '\'' +
                ", administrativeLevelValue='" + administrativeLevelValue + '\'' +
                '}';
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberTypeValue() {
        return memberTypeValue;
    }

    public void setMemberTypeValue(String memberTypeValue) {
        this.memberTypeValue = memberTypeValue;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyIdValue() {
        return companyIdValue;
    }

    public void setCompanyIdValue(String companyIdValue) {
        this.companyIdValue = companyIdValue;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
    }

    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
    }

    public String getAdministrativeLevelValue() {
        return administrativeLevelValue;
    }

    public void setAdministrativeLevelValue(String administrativeLevelValue) {
        this.administrativeLevelValue = administrativeLevelValue;
    }
}
