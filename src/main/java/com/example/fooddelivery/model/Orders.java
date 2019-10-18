package com.example.fooddelivery.model;

import java.util.Date;

public class Orders {

    private Integer o_id;
    private Date date;
    private String c_id;
    private String pay_type;

    public Orders()
    {

    }

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }




}
