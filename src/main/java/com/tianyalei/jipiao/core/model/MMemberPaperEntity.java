package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
* 会员证件表
* @author Bai
* @date 2019/01/04 11:40
*/
@Entity
@Table(name = "M_MemberPaper", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberPaperEntity extends BaseIdEntity {
        /**
        *会员卡号
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *证件类型
        */
        @Basic
        @Column(name = "PaperType")
        private String paperType;
        /**
        *证件号码
        */
        @Basic
        @Column(name = "PaperNum")
        private String paperNum;
        /**
        *有效期
        */
        @Basic
        @Column(name = "ValidityDate")
        private Date validityDate;
        /**
        *是否可用
        */
        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;
        /**
        *是否删除
        */
        @Basic
        @Column(name = "IsDelete")
        private Boolean isDelete;

        public String getCardNum() {
        return this.cardNum;
        }
        public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        }





        public String getPaperType() {
        return this.paperType;
        }
        public void setPaperType(String paperType) {
        this.paperType = paperType;
        }





        public String getPaperNum() {
        return this.paperNum;
        }
        public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
        }






        public Date getValidityDate() {
        return this.validityDate;
        }
        public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
        }








        public Boolean getIsEnable() {
        return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
        }





        public Boolean getIsDelete() {
        return this.isDelete;
        }
        public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        }


}
