package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberLinkmen", catalog = "")
public class MMemberLinkmenEntity extends BaseIdEntity {
    private String cardNum;
    private String linkmen;
    private String linkCardNum;

    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "Linkmen")
    public String getLinkmen() {
        return linkmen;
    }

    public void setLinkmen(String linkmen) {
        this.linkmen = linkmen;
    }

    @Basic
    @Column(name = "LinkCardNum")
    public String getLinkCardNum() {
        return linkCardNum;
    }

    public void setLinkCardNum(String linkCardNum) {
        this.linkCardNum = linkCardNum;
    }

}
