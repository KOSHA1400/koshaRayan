package com.example.kosharyan.model.porsesh;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PorseshResponse implements Serializable
{

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("code-r")
    @Expose
    private String codeR;
    @SerializedName("result")
    @Expose
    private Boolean result;
    private final static long serialVersionUID = 3316399300918426718L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCodeR() {
        return codeR;
    }

    public void setCodeR(String codeR) {
        this.codeR = codeR;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}

