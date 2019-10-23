package com.example.fooddelivery.model;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {

    @Id
    private Integer id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="payment_type")
    private String paymentType;

    @Column(name="amount")
    private Double amount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
