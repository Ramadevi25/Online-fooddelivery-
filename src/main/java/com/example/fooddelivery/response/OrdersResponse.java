package com.example.fooddelivery.response;
import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.Payment;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class OrdersResponse {

    private Integer id;

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    private Customer customerId;
    private Date date;
    private Time time;

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    private Double totalprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }





    }
