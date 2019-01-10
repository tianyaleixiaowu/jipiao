package com.tianyalei.jipiao.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
* 会员地址表
* @author Bai
* @date 2019/01/07 10:44
*/
@Entity
@Table(name = "M_MemberAddress", catalog = "")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class MMemberAddressEntity extends BaseIdEntity{

        /**
        *
        */
        @Basic
        @Column(name = "CardNum")
        private String cardNum;
        /**
        *联系人
        */
        @Basic
        @Column(name = "Linkman")
        private String linkman;
        /**
        *省
        */
        @Basic
        @Column(name = "Province")
        private String province;
        /**
        *市
        */
        @Basic
        @Column(name = "City")
        private String city;
        /**
        *
        */
        @Basic
        @Column(name = "Area")
        private String area;
        /**
        *邮编
        */
        @Basic
        @Column(name = "PostCode")
        private String postCode;
        /**
        *详细地址
        */
        @Basic
        @Column(name = "DetailsAddress")
        private String detailsAddress;
        /**
        *联系手机号
        */
        @Basic
        @Column(name = "CellPhone")
        private String cellPhone;
        /**
        *座机号码
        */
        @Basic
        @Column(name = "TelePhone")
        private String telePhone;
        /**
        *是否为默认地址
        */
        @Basic
        @Column(name = "IsDefault")
        private Byte isDefault;
        /**
         *是否可用
         */
        @Basic
        @Column(name = "IsEnable")
        private Boolean isEnable;

        public Boolean getIsEnable() {
                return this.isEnable;
        }
        public void setIsEnable(Boolean isEnable) {
                this.isEnable = isEnable;
        }

        public String getCardNum() {
        return this.cardNum;
        }
        public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
        }


        public String getLinkman() {
        return this.linkman;
        }
        public void setLinkman(String linkman) {
        this.linkman = linkman;
        }

        public String getProvince() {
        return this.province;
        }
        public void setProvince(String province) {
        this.province = province;
        }

        public String getCity() {
        return this.city;
        }
        public void setCity(String city) {
        this.city = city;
        }

        public String getArea() {
        return this.area;
        }
        public void setArea(String area) {
        this.area = area;
        }



        public String getPostCode() {
        return this.postCode;
        }
        public void setPostCode(String postCode) {
        this.postCode = postCode;
        }


        public String getDetailsAddress() {
        return this.detailsAddress;
        }
        public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
        }



        public String getCellPhone() {
        return this.cellPhone;
        }
        public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        }


        public String getTelePhone() {
        return this.telePhone;
        }
        public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
        }




        public Byte getIsDefault() {
        return this.isDefault;
        }
        public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
        }

}
