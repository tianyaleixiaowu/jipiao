package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_CompanyConfig", catalog = "")
public class MCompanyConfigEntity implements Serializable {
    private int companyId;
    private byte configKey;

    @Id
    @Column(name = "CompanyID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Id
    @Column(name = "ConfigKey")
    public byte getConfigKey() {
        return configKey;
    }

    public void setConfigKey(byte configKey) {
        this.configKey = configKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MCompanyConfigEntity that = (MCompanyConfigEntity) o;
        return companyId == that.companyId &&
                configKey == that.configKey;
    }

    @Override
    public int hashCode() {

        return Objects.hash(companyId, configKey);
    }
}
