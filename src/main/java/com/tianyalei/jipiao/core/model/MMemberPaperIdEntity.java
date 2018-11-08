package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberPaper", catalog = "")
public class MMemberPaperIdEntity extends BaseIdEntity {
    private String cardNum;
    private String paperType;
    private String paperNum;
    private Timestamp validityDate;
    private boolean isEnable;


    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "PaperType")
    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
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
    @Column(name = "ValidityDate")
    public Timestamp getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Timestamp validityDate) {
        this.validityDate = validityDate;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean enable) {
        isEnable = enable;
    }
}
