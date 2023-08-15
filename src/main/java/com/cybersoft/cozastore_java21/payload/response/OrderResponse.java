package com.cybersoft.cozastore_java21.payload.response;

import java.sql.Date;
import java.util.List;

public class OrderResponse {
    private int id;
    private int country_id;
    private Date date;
    private int user_id;


    public OrderResponse() {
    }

    public OrderResponse(int id, int country_id, Date date, int user_id) {
        this.id = id;
        this.country_id = country_id;
        this.date = date;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
