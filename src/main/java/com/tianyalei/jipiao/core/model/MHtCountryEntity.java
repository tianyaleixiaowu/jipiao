package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_HTCountry", catalog = "")
public class MHtCountryEntity {

    private String cnName;
    private String enName;
    private String countryCode;
    private String continent;

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

    @Id
    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "Continent")
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MHtCountryEntity that = (MHtCountryEntity) o;
        return Objects.equals(cnName, that.cnName) &&
                Objects.equals(enName, that.enName) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(continent, that.continent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cnName, enName, countryCode, continent);
    }
}
