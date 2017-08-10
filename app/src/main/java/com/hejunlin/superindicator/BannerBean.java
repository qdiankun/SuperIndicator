package com.hejunlin.superindicator;

/**
 * Created by diankun.qiu on 2017/8/10.
 */

public class BannerBean {

    private String url = "";
    private String titie = "";

    public BannerBean(String url, String titie) {
        this.url = url;
        this.titie = titie;
    }

    public String getUrl() {
        return url;
    }

    public String getTitie() {
        return titie;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "url='" + url + '\'' +
                ", titie='" + titie + '\'' +
                '}';
    }
}
