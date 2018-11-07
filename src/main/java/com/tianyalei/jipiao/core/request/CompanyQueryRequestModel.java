package com.tianyalei.jipiao.core.request;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
public class CompanyQueryRequestModel extends BaseQueryModel {
    private String companyName;
    private String panelname;
    private Boolean isEnable;
    @Override
    public String toString() {
        return "CompanyQueryRequestModel{" +
                "companyName='" + companyName + '\'' +
                ", panelname='" + panelname + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPanelname() {
        return panelname;
    }

    public void setPanelname(String panelname) {
        this.panelname = panelname;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
