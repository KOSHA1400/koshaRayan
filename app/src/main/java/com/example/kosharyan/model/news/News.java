
package com.example.kosharyan.model.news;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class News implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("fk_cat")
    @Expose
    private String fkCat;
    @SerializedName("state")
    @Expose
    private String state;
    private final static long serialVersionUID = 9200718322672205685L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFkCat() {
        return fkCat;
    }

    public void setFkCat(String fkCat) {
        this.fkCat = fkCat;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
