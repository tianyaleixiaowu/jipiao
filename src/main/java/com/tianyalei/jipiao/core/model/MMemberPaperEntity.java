package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberPaper", catalog = "")
public class MMemberPaperEntity extends BaseEntity {
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
    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
