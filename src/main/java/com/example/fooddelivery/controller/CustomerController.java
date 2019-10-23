package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.request.CustomerRequest;
import com.example.fooddelivery.response.*;
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
    private CustomerService customerservice;

    @Autowired
    private RestraurantService restraurantService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping()
    public List<CustomerDetailResponse> getCustomerDetails() {
        return customerservice.fetchCustomersDetails();
    }

    @GetMapping(value="/{customerId}")
    public CustomerDetailResponse getCustomerById(@PathVariable("customerId") Integer id) {
        return customerservice.fetchCustomerById(id);
    }

    @GetMapping(value="orderdetail/{customerId}")
    public CustomerResponse getCustomerOrderDetail(@PathVariable("customerId") Integer customerId) {
        return customerservice.fetchCustomerOrderDetails(customerId);
    }

    @GetMapping(value="/customerId/{customerId}")
    public CustomerDetailResponse getOrderDetail(@PathVariable("customerId") Integer customerId)
    {
        return customerservice.fetchOrder(customerId);
    }
    @PostMapping(value="/addCustomer")
    public void addCustomer(@RequestBody CustomerRequest customerRequest)
    {
         customerservice.addCustomerDetails(customerRequest);
    }




}

