package com.tianyalei.jipiao.core.response;

import com.tianyalei.jipiao.core.request.HotelModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/19.
 */
public class CompanyTravelSettingResponseVO {
    private Integer travelLevelId;

    /**
     * 和plane和train是一对一的
     */
    private String planeLevel;
    private String trainLevel;
    /**
     * 和下面的一对多的
     */
    private List<HotelModel> hotels = new ArrayList<>();

    private String levelName;

    @Override
    public String toString() {
        return "CompanyTravelSettingResponseVO{" +
                "travelLevelId=" + travelLevelId +
                ", planeLevel='" + planeLevel + '\'' +
                ", trainLevel='" + trainLevel + '\'' +
                ", hotels=" + hotels +
                ", levelName='" + levelName + '\'' +
                '}';
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getTravelLevelId() {
        return travelLevelId;
    }

    public void setTravelLevelId(Integer travelLevelId) {
        this.travelLevelId = travelLevelId;
    }

    public String getPlaneLevel() {
        return planeLevel;
    }

    public void setPlaneLevel(String planeLevel) {
        this.planeLevel = planeLevel;
    }

    public String getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(String trainLevel) {
        this.trainLevel = trainLevel;
    }

    public List<HotelModel> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelModel> hotels) {
        this.hotels = hotels;
    }
}
