package com.example.fooddelivery.response;

import java.util.List;

public class CustomerResponse {

    private Integer id;
    private String name;
    private Long mobileNo;
    private String email;

    List<OrdersResponse> orderdetails;

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }


    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public List<OrdersResponse> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<OrdersResponse> orderdetails) {
        this.orderdetails = orderdetails;
    }
}
