package com.tianyalei.jipiao.core.request;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author wuweifeng wrote on 2018/11/19.
 */
public class HotelModel {
    @NotNull(message = "城市等级不能为空")
    private Integer cityLevelId;
    @NotNull(message = "名字不能为空")
    private String levelName;
    @NotNull(message = "账号不能为空")
    private BigDecimal hotelFeeValue;
    private String currency;

    @Override
    public String toString() {
        return "HotelModel{" +
                "cityLevelId=" + cityLevelId +
                ", levelName='" + levelName + '\'' +
                ", hotelFeeValue=" + hotelFeeValue +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCityLevelId() {
        return cityLevelId;
    }

    public void setCityLevelId(Integer cityLevelId) {
        this.cityLevelId = cityLevelId;
    }

    public BigDecimal getHotelFeeValue() {
        return hotelFeeValue;
    }

    public void setHotelFeeValue(BigDecimal hotelFeeValue) {
        this.hotelFeeValue = hotelFeeValue;
    }
}
