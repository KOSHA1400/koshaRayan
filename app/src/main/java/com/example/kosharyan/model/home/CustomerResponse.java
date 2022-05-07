
package com.example.kosharyan.model.home;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CustomerResponse implements Serializable
{

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("eslider")
    @Expose
    private List<Eslider> eslider = null;
    @SerializedName("customer")
    @Expose
    private List<Customer> customer = null;
    private final static long serialVersionUID = 8128406554735919406L;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Eslider> getEslider() {
        return eslider;
    }

    public void setEslider(List<Eslider> eslider) {
        this.eslider = eslider;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

}
