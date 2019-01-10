package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* 会员亲属关系表
* @author Bai
* @date 2019/01/07 11:00
*/
@Entity
@Table(name = "M_MemberRelationShip", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberRelationShipEntity extends BaseIdEntity{

        /**
        *
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *亲属卡号
        */
        @Basic
        @Column(name = "KinsfolkCardNum")
        private String kinsfolkCardNum;
        /**
        *亲属姓名
        */
        @Basic
        @Column(name = "KinsfolkRealName")
        private String kinsfolkRealName;
        /**
        *关系类型
        */
        @Basic
        @Column(name = "RelationshipType")
        private String relationshipType;
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





        public String getKinsfolkCardNum() {
        return this.kinsfolkCardNum;
        }
        public void setKinsfolkCardNum(String kinsfolkCardNum) {
        this.kinsfolkCardNum = kinsfolkCardNum;
        }





        public String getKinsfolkRealName() {
        return this.kinsfolkRealName;
        }
        public void setKinsfolkRealName(String kinsfolkRealName) {
        this.kinsfolkRealName = kinsfolkRealName;
        }





        public String getRelationshipType() {
        return this.relationshipType;
        }
        public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
        }









        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }


}
