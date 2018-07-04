package com.example.android.newsapp;

import java.util.Date;

public class Article {
    private final String webUrl;

    private final String webTitle;

//    private final String contributor;

    private final String sectionName;

//    private  final Date webPublicationDate;

    public Article(String url, String title, String newSectionName){
        webUrl = url;
        webTitle = title;
//        contributor = newContributor;
        sectionName = newSectionName;
//        webPublicationDate = date;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getWebTitle() {
        return webTitle;
    }

//    public String getContributor() {
//        return contributor;
//    }

    public String getSectionName() {
        return sectionName;
    }

//    public Date getWebPublicationDate() {
//        return webPublicationDate;
//    }
}
