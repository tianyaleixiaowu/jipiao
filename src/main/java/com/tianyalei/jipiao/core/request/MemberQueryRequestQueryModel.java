package com.tianyalei.jipiao.core.request;

/**
 * @author wuweifeng wrote on 2018/11/5.
 */
public class MemberQueryRequestQueryModel extends BaseQueryModel {
     private String cardNum;
     /**
      * 会员类型（数据字典 GroupId=7）
      */
     private String memberType;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 是否模糊搜索，
     */
    private boolean fuzzy;
    /**
     * 会员所属单位
     */
    private Integer companyId;
    /**
     * HR人员编号
     */
    private String hrCode;
    /**
     * 证件号码（密文）
     */
    private String paperNum;
    /**
     * 手机号码（密文）
     */
    private String cellPhone;
    /**
     * 行政级别（GroupID=31）
     */
    private String administrativeLevel;
    /**
     * 职务
     */
    private String position;
    ///**
    // * 会员级别（数据字典 GroupId=41），勾选vip的话，memberClass=3
    // */
    //private String memberClass;
    /**
     * 是否是vip
     */
    private Boolean isVip;
    /**
     * 是否可用
     */
    private Boolean isEnable;


    @Override
    public String toString() {
        return "MemberQueryRequestModel{" +
                "cardNum='" + cardNum + '\'' +
                ", memberType='" + memberType + '\'' +
                ", realName='" + realName + '\'' +
                ", fuzzy=" + fuzzy +
                ", companyId=" + companyId +
                ", hrCode='" + hrCode + '\'' +
                ", paperNum='" + paperNum + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", administrativeLevel='" + administrativeLevel + '\'' +
                ", position='" + position + '\'' +
                //", memberClass='" + memberClass + '\'' +
                ", isVip=" + isVip +
                ", isEnable=" + isEnable +
                '}';
    }


    public Boolean getIsVip() {
        return isVip;
    }

    public void setIsVip(Boolean vip) {
        isVip = vip;
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

    //public String getMemberClass() {
    //    return memberClass;
    //}
    //
    //public void setMemberClass(String memberClass) {
    //    this.memberClass = memberClass;
    //}

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public boolean isFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(boolean fuzzy) {
        this.fuzzy = fuzzy;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public String getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAdministrativeLevel() {
        return administrativeLevel;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeLevel = administrativeLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean enable) {
        isEnable = enable;
    }
}
