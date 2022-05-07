
package com.example.kosharyan.model.member;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Member implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("family")
    @Expose
    private String family;
    @SerializedName("takhasos")
    @Expose
    private String takhasos;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("email")
    @Expose
    private String email;
    private final static long serialVersionUID = 8283810614574217571L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getTakhasos() {
        return takhasos;
    }

    public void setTakhasos(String takhasos) {
        this.takhasos = takhasos;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
