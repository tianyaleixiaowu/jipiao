package com.tianyalei.jipiao.core.response;

/**
 * @author wuweifeng wrote on 2018/11/20.
 */
public class MemberBalanceListResponseVO {
    private Integer id;
    private String cardNum;
    private int companyId;
    private String companyName;
    private int travelLevelId;
    private boolean isEnable = true;

    private String travelLevelName;

    @Override
    public String toString() {
        return "MemberBalanceListResponseVO{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", travelLevelId=" + travelLevelId +
                ", isEnable=" + isEnable +
                ", travelLevelName='" + travelLevelName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTravelLevelId() {
        return travelLevelId;
    }

    public void setTravelLevelId(int travelLevelId) {
        this.travelLevelId = travelLevelId;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }

    public String getTravelLevelName() {
        return travelLevelName;
    }

    public void setTravelLevelName(String travelLevelName) {
        this.travelLevelName = travelLevelName;
    }
}
