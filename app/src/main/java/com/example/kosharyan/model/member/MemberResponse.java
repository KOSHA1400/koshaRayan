
package com.example.kosharyan.model.member;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MemberResponse implements Serializable
{

    @SerializedName("stat")
    @Expose
    private String stat;
    @SerializedName("member")
    @Expose
    private List<Member> member = null;
    private final static long serialVersionUID = 3216418573754392952L;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

}
