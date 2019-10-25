package com.example.fooddelivery.request;

import com.example.fooddelivery.model.Payment;
import com.example.fooddelivery.response.PaymentResponse;

import java.sql.Date;
import java.sql.Time;

public class CartOrderdetail {

    private CartRequest cartRequest;
    private Date date;
    private Time time;
    private Double totalprice;
    private OrderdetailRequest orderdetailRequest;
    private PaymentResponse paymentResponse;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public OrderdetailRequest getOrderdetailRequest() {
        return orderdetailRequest;
    }

    public void setOrderdetailRequest(OrderdetailRequest orderdetailRequest) {
        this.orderdetailRequest = orderdetailRequest;
    }

    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(PaymentResponse paymentResponse) {
        this.paymentResponse = paymentResponse;
    }








    public CartRequest getCartRequest() {
        return cartRequest;
    }

    public void setCartRequest(CartRequest cartRequest) {
        this.cartRequest = cartRequest;
    }




}
