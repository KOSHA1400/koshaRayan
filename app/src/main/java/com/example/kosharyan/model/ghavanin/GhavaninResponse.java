
package com.example.kosharyan.model.ghavanin;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GhavaninResponse implements Serializable
{

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("result")
    @Expose
    private List<Ghavanin> result = null;
    private final static long serialVersionUID = 8240794460849211014L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Ghavanin> getResult() {
        return result;
    }

    public void setResult(List<Ghavanin> result) {
        this.result = result;
    }

}
