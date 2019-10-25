package com.example.fooddelivery.controller;

import com.example.fooddelivery.request.CustomerRequest;
import com.example.fooddelivery.response.*;
import com.example.fooddelivery.service.CustomerService;
import com.example.fooddelivery.service.OrdersService;
import com.example.fooddelivery.service.RestraurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    private static  Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerservice;

    @Autowired
    private RestraurantService restraurantService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("")
    public List<CustomerDetailResponse> getAllCustomerDetails() {
        return customerservice.fetchCustomersDetails();
    }


    @GetMapping(value="/{customerId}")
    public CustomerDetailResponse getCustomerById(@PathVariable("customerId") Integer id) {
        return customerservice.fetchCustomerById(id);
    }

    //for particular customerid orders is displayed
    @GetMapping(value="orderdetail/{customerId}")
    public CustomerResponse getCustomerOrders(@PathVariable("customerId") Integer customerId) {
        return customerservice.fetchCustomerOrders(customerId);
    }

    @PostMapping(value="/addCustomer")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
         return customerservice.addCustomerDetails(customerRequest);
    }

    @PostMapping(value="/updatecustomer")
    public void updateCustomer(@RequestBody CustomerRequest customerRequest) {
        customerservice.updateCustomerById(customerRequest);
    }
    @PostMapping("/{username}/{password}")
    public String verifyCustomer(@PathVariable("username")String username,@PathVariable("password")String password)
    {
        return customerservice.checkCustomer(username,password);
    }
}

