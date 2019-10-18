package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import com.example.fooddelivery.service.CustomerService;
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

    @GetMapping()
    public List<CustomerResponse> getCustomerDetails() {
        return customerservice.fetchcustomersdetails();
    }

    @GetMapping(value="/{id}")
    public CustomerResponse getCustomerById(@PathVariable("id") Integer id) {
        return customerservice.fetchCustomerById(id);
    }
}

