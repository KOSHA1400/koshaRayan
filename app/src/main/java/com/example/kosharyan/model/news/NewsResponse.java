
package com.example.kosharyan.model.news;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NewsResponse implements Serializable
{

    @SerializedName("news")
    @Expose
    private List<News> news = null;
    @SerializedName("newscat")
    @Expose
    private List<Newscat> newscat = null;
    private final static long serialVersionUID = -4300162943462226622L;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Newscat> getNewscat() {
        return newscat;
    }

    public void setNewscat(List<Newscat> newscat) {
        this.newscat = newscat;
    }

}
