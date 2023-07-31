package com.cybersoft.cozastore_java21.payload.request;

import java.util.List;

public class OrderRequest {
    private int country_id;
    private List<OrderProductRequest> listProduct;


    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public List<OrderProductRequest> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<OrderProductRequest> listProduct) {
        this.listProduct = listProduct;
    }
}
