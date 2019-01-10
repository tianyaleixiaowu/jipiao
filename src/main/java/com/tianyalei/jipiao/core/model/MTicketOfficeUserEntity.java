package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* 票台用户表
* @author Bai
* @date 2019/01/08 11:55
*/
@Entity
@Table(name = "M_TicketOfficeUser", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MTicketOfficeUserEntity extends BaseIdEntity{

        /**
        *用户名
        */
        @Basic
        @Column(name = "UserID")
        private String userID;
        /**
        *所属票台
        */
        @Basic
        @Column(name = "TicketOfficeID")
        private Integer ticketOfficeID;
        /**
        *真实姓名
        */
        @Basic
        @Column(name = "RealName")
        private String realName;
        /**
        *手机号码
        */
        @Basic
        @Column(name = "LinkPhone")
        private String linkPhone;
        /**
        *工号
        */
        @Basic
        @Column(name = "WorkNum")
        private String workNum;
        /**
        *是否坐席
        */
        @Basic
        @Column(name = "IsOperator")
        private Byte isOperator;
        /**
        *是否可用
        */
        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;
        /**
        *关联票台
        */
        @Basic
        @Column(name = "RelationTicketOffice")
        private String relationTicketOffice;

        public String getUserID() {
        return this.userID;
        }
        public void setUserID(String userID) {
        this.userID = userID;
        }








        public Integer getTicketOfficeID() {
        return this.ticketOfficeID;
        }
        public void setTicketOfficeID(Integer ticketOfficeID) {
        this.ticketOfficeID = ticketOfficeID;
        }


        public String getRealName() {
        return this.realName;
        }
        public void setRealName(String realName) {
        this.realName = realName;
        }





        public String getLinkPhone() {
        return this.linkPhone;
        }
        public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
        }





        public String getWorkNum() {
        return this.workNum;
        }
        public void setWorkNum(String workNum) {
        this.workNum = workNum;
        }










        public Byte getIsOperator() {
        return this.isOperator;
        }
        public void setIsOperator(Byte isOperator) {
        this.isOperator = isOperator;
        }




        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }

        public String getRelationTicketOffice() {
        return this.relationTicketOffice;
        }
        public void setRelationTicketOffice(String relationTicketOffice) {
        this.relationTicketOffice = relationTicketOffice;
        }






}
