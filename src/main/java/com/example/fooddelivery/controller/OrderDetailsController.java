package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Orderdetails;
import com.example.fooddelivery.response.OrderDetailsResponse;
import com.example.fooddelivery.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailsController {
    @Autowired
   private OrderDetailService orderDetailService;


    @GetMapping(value="/orderdetail/{orderId}")
    public OrderDetailsResponse getOrderDetailByIds(@PathVariable("orderId") Integer orderId){
        return orderDetailService.fetchOrderDetailById(orderId);
    }

}
