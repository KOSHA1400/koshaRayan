
package com.example.kosharyan.model.eftekharat;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EftekharResponse implements Serializable
{

    @SerializedName("stat")
    @Expose
    private String stat;
    @SerializedName("eftekhar")
    @Expose
    private List<Eftekhar> eftekhar = null;
    private final static long serialVersionUID = 7004954593615735335L;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<Eftekhar> getEftekhar() {
        return eftekhar;
    }

    public void setEftekhar(List<Eftekhar> eftekhar) {
        this.eftekhar = eftekhar;
    }

}
