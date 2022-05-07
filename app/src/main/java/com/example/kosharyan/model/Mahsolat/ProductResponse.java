
package com.example.kosharyan.model.Mahsolat;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductResponse implements Serializable
{

    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("state")
    @Expose
    private String state;
    private final static long serialVersionUID = 1446307622490793271L;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
