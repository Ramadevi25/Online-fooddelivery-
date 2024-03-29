package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/{customerId}/{totalprice}")
    public List<OrdersResponse> getOrderDetails(@PathVariable("customerId")Integer customerId,@PathVariable("totalprice")Integer totalprice)
    {
        return ordersService.getOrderDetailsByCustomerId(customerId,totalprice);
    }

    @PostMapping(value="/addorder")
    public String postOrder(@RequestBody OrdersResponse ordersResponse)
    {
        return ordersService.addorder(ordersResponse);
    }

}
