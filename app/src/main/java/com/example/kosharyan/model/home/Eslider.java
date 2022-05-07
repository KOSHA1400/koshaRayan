
package com.example.kosharyan.model.home;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Eslider implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modifi")
    @Expose
    private String modifi;
    private final static long serialVersionUID = -3892297934196112349L;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModifi() {
        return modifi;
    }

    public void setModifi(String modifi) {
        this.modifi = modifi;
    }

}
