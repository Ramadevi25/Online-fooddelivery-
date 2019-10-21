package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping(value="/orders")
    public List<OrdersResponse> getOrders() {
        return ordersService.fetchOrders();
    }
}
