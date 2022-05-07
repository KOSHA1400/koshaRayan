package com.example.kosharyan.model.tamas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TamasResponse implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("creat")
    @Expose
    private String creat;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobail")
    @Expose
    private String mobail;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("insert")
    @Expose
    private String insert;
    @SerializedName("stat")
    @Expose
    private String stat;
    @SerializedName("tamas")
    @Expose
    private Boolean tamas;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreat() {
        return creat;
    }

    public void setCreat(String creat) {
        this.creat = creat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobail() {
        return mobail;
    }

    public void setMobail(String mobail) {
        this.mobail = mobail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Boolean getTamas() {
        return tamas;
    }

    public void setTamas(Boolean tamas) {
        this.tamas = tamas;
    }

}

