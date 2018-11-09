package com.tianyalei.jipiao.core.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/9.
 */
public class Menu {
    private String id;
    private String app_id;
    private String parent_id;
    private String code;
    private String name;
    private String url;
    private String icon;
    private int level;
    private int order;
    private String descript;
    private String open_type;
    private boolean is_show;
    private List<Menu> child_menu = new ArrayList<>();

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", app_id='" + app_id + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", order=" + order +
                ", descript='" + descript + '\'' +
                ", open_type='" + open_type + '\'' +
                ", is_show=" + is_show +
                ", child_menu=" + child_menu +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public boolean isIs_show() {
        return is_show;
    }

    public void setIs_show(boolean is_show) {
        this.is_show = is_show;
    }

    public List<Menu> getChild_menu() {
        return child_menu;
    }

    public void setChild_menu(List<Menu> child_menu) {
        this.child_menu = child_menu;
    }
}
