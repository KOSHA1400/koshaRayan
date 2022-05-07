
package com.example.kosharyan.model.tamasbama;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TamasbamaResponse implements Serializable
{

    @SerializedName("stat")
    @Expose
    private String stat;
    @SerializedName("tamas")
    @Expose
    private Tamas tamas;
    private final static long serialVersionUID = -7739983003001540407L;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Tamas getTamas() {
        return tamas;
    }

    public void setTamas(Tamas tamas) {
        this.tamas = tamas;
    }

}
