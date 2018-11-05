package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * 会员卡卡号段表
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberCard", catalog = "")
public class MMemberCardEntity extends BaseEntity {
    /**
     * 发卡单位ID
     */
    private String companyId;
    private String companyName;
    /**
     * 发卡人姓名
     */
    private String realName;
    /**
     * 发卡人用户ID
     */
    private String userId;
    /**
     * 开始卡号
     */
    private int beginNum;
    private int endNum;
    /**
     * 可用卡号总数
     */
    private int countNum;
    private String exclusiveNum;


    @Basic
    @Column(name = "CompanyID")
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "CompanyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
    @Column(name = "UserID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "BeginNum")
    public int getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(int beginNum) {
        this.beginNum = beginNum;
    }

    @Basic
    @Column(name = "EndNum")
    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    @Basic
    @Column(name = "CountNum")
    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }


    @Basic
    @Column(name = "ExclusiveNum")
    public String getExclusiveNum() {
        return exclusiveNum;
    }

    public void setExclusiveNum(String exclusiveNum) {
        this.exclusiveNum = exclusiveNum;
    }

}
