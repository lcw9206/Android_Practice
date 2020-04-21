package com.example.practice.appstore;

import android.widget.ImageView;

import java.net.URL;

// 앱 정보를 담아놓는 Model
public class AppStore {

    public String appName;
    public String companyName;
    public String updateDate;
    public URL downloadUrl;
    public ImageView appImage;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public ImageView getAppImage() {
        return appImage;
    }

    public void setAppImage(ImageView appImage) {
        this.appImage = appImage;
    }

    public void setDownloadUrl(URL downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public URL getDownloadUrl(URL downloadUrl) {
        return downloadUrl;
    }

    @Override
    public String toString() {
        return "Appstore{" +
                "appName='" + appName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", appImage=" + appImage + '\'' +
                ", downloadUrl=" + downloadUrl  +
                '}';
    }

    public AppStore(String appName, String companyName, String updateDate) {
        this.appName = appName;
        this.companyName = companyName;
        this.updateDate = updateDate;
    }
}
