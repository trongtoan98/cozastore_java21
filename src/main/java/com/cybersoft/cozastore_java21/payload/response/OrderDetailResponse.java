package com.cybersoft.cozastore_java21.payload.response;

public class OrderDetailResponse {
    private int order_id;
    private int product_id;
    private double price;
    private int quantity;

    public OrderDetailResponse() {
    }

    public OrderDetailResponse(int order_id, int product_id, double price, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
