package com.tianyalei.jipiao.core.model;

import javax.persistence.*;

/**
 * 会员卡号表
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_MemberCardNum", catalog = "")
public class MMemberCardNumEntity {
    private String cardNum;
    private Integer id;
    /**
     * 所属卡号段ID
     */
    private Integer cardNumId;

    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CardNumID")
    public Integer getCardNumId() {
        return cardNumId;
    }

    public void setCardNumId(Integer cardNumId) {
        this.cardNumId = cardNumId;
    }


}
