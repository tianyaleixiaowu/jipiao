package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_SystemDistrict", catalog = "")
public class MSystemDistrictEntity {
    private String id;
    private String parentId;
    private String district;
    private byte districtType;
    private String pinyin;
    private String englishName;
    private String longitude;
    private String latitude;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ParentID")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "District")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "DistrictType")
    public byte getDistrictType() {
        return districtType;
    }

    public void setDistrictType(byte districtType) {
        this.districtType = districtType;
    }

    @Basic
    @Column(name = "Pinyin")
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Basic
    @Column(name = "EnglishName")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "Longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "Latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MSystemDistrictEntity that = (MSystemDistrictEntity) o;
        return districtType == that.districtType &&
                Objects.equals(id, that.id) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(district, that.district) &&
                Objects.equals(pinyin, that.pinyin) &&
                Objects.equals(englishName, that.englishName) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, parentId, district, districtType, pinyin, englishName, longitude, latitude);
    }
}
