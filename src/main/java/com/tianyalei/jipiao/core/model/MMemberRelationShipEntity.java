package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_MemberRelationShip", catalog = "")
public class MMemberRelationShipEntity extends BaseIdEntity {
    private String cardNum;
    private String kinsfolkCardNum;
    private String kinsfolkRealName;
    private String relationshipType;


    @Basic
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "KinsfolkCardNum")
    public String getKinsfolkCardNum() {
        return kinsfolkCardNum;
    }

    public void setKinsfolkCardNum(String kinsfolkCardNum) {
        this.kinsfolkCardNum = kinsfolkCardNum;
    }

    @Basic
    @Column(name = "KinsfolkRealName")
    public String getKinsfolkRealName() {
        return kinsfolkRealName;
    }

    public void setKinsfolkRealName(String kinsfolkRealName) {
        this.kinsfolkRealName = kinsfolkRealName;
    }

    @Basic
    @Column(name = "RelationshipType")
    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

}
