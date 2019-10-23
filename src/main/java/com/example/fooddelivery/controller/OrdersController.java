package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.response.CustomerDetailResponse;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //all orders
    @GetMapping(value="/orders")
    public List<OrdersResponse> getOrders() {
        return ordersService.fetchOrders();
    }

    //get orderby id
    @GetMapping(value="orderid/{id}")
    public OrdersResponse getOrder(@PathVariable("id")Integer id)
    {
        return ordersService.fetchOrders(id);
    }

    @GetMapping(value="/{customerId}/{totalprice}")
    public List<OrdersResponse> getOrderDetails(@PathVariable("customerId")Integer customerId,@PathVariable("totalprice")Integer totalprice)
    {
        return ordersService.getOrderDetailsByCustomerId(customerId,totalprice);
    }


}
