package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * 会员领导表
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberLeader", catalog = "")
public class MMemberLeaderEntity extends BaseIdEntity {
    private String cardNum;
    private String leaderRealName;
    /**
     * 领导卡号
     */
    private String leaderCardNum;

    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "LeaderRealName")
    public String getLeaderRealName() {
        return leaderRealName;
    }

    public void setLeaderRealName(String leaderRealName) {
        this.leaderRealName = leaderRealName;
    }

    @Basic
    @Column(name = "LeaderCardNum")
    public String getLeaderCardNum() {
        return leaderCardNum;
    }

    public void setLeaderCardNum(String leaderCardNum) {
        this.leaderCardNum = leaderCardNum;
    }


}
