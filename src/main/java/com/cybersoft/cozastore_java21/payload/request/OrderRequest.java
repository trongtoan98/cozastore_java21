package com.cybersoft.cozastore_java21.payload.request;

import java.util.List;

public class OrderRequest {

    private int country_id;
    private int user_id;
    private List<OrderProductRequest> listProduct;


    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<OrderProductRequest> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<OrderProductRequest> listProduct) {
        this.listProduct = listProduct;
    }
}
