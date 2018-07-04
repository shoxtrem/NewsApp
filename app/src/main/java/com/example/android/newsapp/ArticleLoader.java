package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    private String url;

    public ArticleLoader(Context context, String newUrl){
        super(context);
        url = newUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */

    @Override
    public List<Article> loadInBackground() {
        if (url == null){
            return null;
        }

        List<Article> articles = QueryUtils.fetchArticleData(url);
        return articles;
    }
}
