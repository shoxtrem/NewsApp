package com.example.android.newsapp;

import java.util.ArrayList;

public class Article {
    private final String webUrl;

    private final String webTitle;

    private final ArrayList<String> contributor;

    private final String sectionName;

    private final String webPublicationDate;

    /**
     * @param url            is the string of the URL of the article
     * @param title          is the title of the article
     * @param newSectionName is the name of the section the article is from
     * @param newContributor is the list of authors of the article
     * @param date           is a String of the date the article was posted
     */
    public Article(String url, String title, String newSectionName, ArrayList<String> newContributor, String date) {
        webUrl = url;
        webTitle = title;
        contributor = newContributor;
        sectionName = newSectionName;
        webPublicationDate = date;
    }

    /**
     * @return the URL of the article as a String
     */
    public String getWebUrl() {
        return webUrl;
    }

    /**
     * @return the name of the article
     */
    public String getWebTitle() {
        return webTitle;
    }

    /**
     * @return a list of the author(s) of the article
     */
    public ArrayList<String> getContributor() {
        return contributor;
    }

    /**
     * @return the name of the section the article belongs to
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @return the date the article was posted as a String
     */
    public String getWebPublicationDate() {
        return webPublicationDate;
    }
}
