package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "API_IPList", catalog = "")
public class ApiIpListEntity {
    private Integer id;
    private String ipAddress;
    private boolean isEnable;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IPAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "IsEnable")
    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiIpListEntity that = (ApiIpListEntity) o;
        return id == that.id &&
                isEnable == that.isEnable &&
                Objects.equals(ipAddress, that.ipAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ipAddress, isEnable);
    }
}
