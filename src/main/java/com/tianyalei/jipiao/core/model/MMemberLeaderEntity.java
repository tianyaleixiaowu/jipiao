package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* 会员领导表
* @author Bai
* @date 2019/01/04 16:40
*/
@Entity
@Table(name = "M_MemberLeader", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberLeaderEntity extends BaseIdEntity{

        /**
        *会员卡号
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *领导名称
        */
        @Basic
        @Column(name = "LeaderRealName")
        private String leaderRealName;
        /**
        *领导卡号
        */
        @Basic
        @Column(name = "LeaderCardNum")
        private String leaderCardNum;
        /**
        *是否可用
        */
        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;

        public String getCardNum() {
        return this.cardNum;
        }
        public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        }





        public String getLeaderRealName() {
        return this.leaderRealName;
        }
        public void setLeaderRealName(String leaderRealName) {
        this.leaderRealName = leaderRealName;
        }





        public String getLeaderCardNum() {
        return this.leaderCardNum;
        }
        public void setLeaderCardNum(String leaderCardNum) {
        this.leaderCardNum = leaderCardNum;
        }





        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }


}
