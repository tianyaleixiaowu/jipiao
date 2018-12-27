package com.tianyalei.jipiao.core.request;

import com.tianyalei.jipiao.core.model.MCompanyBudgetEntity;
import com.xiaoleilu.hutool.util.BeanUtil;

import java.math.BigDecimal;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
public class CompanyBudgetAddRequestModel {
    private Integer id;
    private Integer companyId;
    private String startDate;
    private String endDate;
    private BigDecimal totalCost;
    private BigDecimal surplusCost;

    public MCompanyBudgetEntity toEntity() {
        MCompanyBudgetEntity entity = new MCompanyBudgetEntity();
        BeanUtil.copyProperties(this, entity);
        return entity;
    }

    @Override
    public String toString() {
        return "CompanyBudgetAddRequestModel{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", totalCost=" + totalCost +
                ", surplusCost=" + surplusCost +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getSurplusCost() {
        return surplusCost;
    }

    public void setSurplusCost(BigDecimal surplusCost) {
        this.surplusCost = surplusCost;
    }
}
