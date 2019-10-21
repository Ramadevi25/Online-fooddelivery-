package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import com.example.fooddelivery.service.CustomerService;
import com.example.fooddelivery.service.FoodItemsService;
import com.example.fooddelivery.service.OrdersService;
import com.example.fooddelivery.service.RestraurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    CustomerRespository customerrespository;

    @Autowired
    CustomerService customerservice;

    @Autowired
    RestraurantService restraurantService;



    @Autowired
    OrdersService ordersService;

    @GetMapping()
    public List<CustomerResponse> getCustomerDetails() {
        return customerservice.fetchCustomersDetails();
    }

    @GetMapping(value="/{id}")
    public CustomerResponse getCustomerById(@PathVariable("id") Integer id) {
        return customerservice.fetchCustomerById(id);
    }
    //get orderdetails using customerid
    @GetMapping(value="/{id}")
    public CustomerResponse getCustomerOrderDetail(@PathVariable("id") Integer id) {
        return customerservice.fetchCustomerOrderDetails(id);
    }





}

