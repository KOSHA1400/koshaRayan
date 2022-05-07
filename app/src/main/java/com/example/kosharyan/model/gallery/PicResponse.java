
package com.example.kosharyan.model.gallery;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PicResponse implements Serializable
{

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("pics")
    @Expose
    private List<Object> pics = null;
    private final static long serialVersionUID = 8565135438625757199L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public List<Object> getPics() {
        return pics;
    }

    public void setPics(List<Object> pics) {
        this.pics = pics;
    }

}
