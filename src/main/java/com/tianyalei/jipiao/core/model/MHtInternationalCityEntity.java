package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_HTInternationalCity", catalog = "")
public class MHtInternationalCityEntity {
    private String cityId;
    private String cnName;
    private String enName;
    private String countryCode;

    @Id
    @Column(name = "CityID")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CNName")
    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    @Basic
    @Column(name = "ENName")
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Basic
    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MHtInternationalCityEntity that = (MHtInternationalCityEntity) o;
        return Objects.equals(cityId, that.cityId) &&
                Objects.equals(cnName, that.cnName) &&
                Objects.equals(enName, that.enName) &&
                Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityId, cnName, enName, countryCode);
    }
}
