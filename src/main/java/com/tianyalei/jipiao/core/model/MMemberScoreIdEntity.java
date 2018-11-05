package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberScore", catalog = "")
public class MMemberScoreIdEntity extends BaseIdEntity {
    private String cardNum;
    /**
     * 积分类型
     */
    private String scoreType;
    //public BigDecimal(String val)　
    private BigDecimal amount;
    private int score;
    private String intro;
    private String orderId;
    private String scoreFromCompanyId;


    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "ScoreType")
    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    @Basic
    @Column(name = "Amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "Intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Basic
    @Column(name = "OrderID")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ScoreFromCompanyID")
    public String getScoreFromCompanyId() {
        return scoreFromCompanyId;
    }

    public void setScoreFromCompanyId(String scoreFromCompanyId) {
        this.scoreFromCompanyId = scoreFromCompanyId;
    }

}
