package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRespository customerRespository;

    public List<CustomerResponse> fetchCustomersDetails()
    {
        List<Customer> customers=customerRespository.findAll();
        List<CustomerResponse> customerdetails = new ArrayList<>();
        customers.forEach(customer ->
        {
            CustomerResponse customerresponse=customerDetails(customer);
            customerdetails.add(customerresponse);
        });
       return customerdetails;
    }
    public CustomerResponse fetchCustomerById(Integer id) {
        Customer customerdetail=customerRespository.findById(id).get();
        //customerdetail.orElseThrow(()-> new CustomerNotFoundException(id));
        CustomerResponse customer=customerDetails(customerdetail);
        return customer;
    }

    public CustomerResponse customerDetails(Customer customerdetail){
        CustomerResponse customer=new CustomerResponse();
        customer.setId(customerdetail.getId());
        customer.setName(customerdetail.getName());
        customer.setAddress(customerdetail.getAddress());
        customer.setEmail(customerdetail.getEmail());
        customer.setMobileNo(customerdetail.getMobileNo());
        return customer;
    }

    public CustomerResponse fetchCustomerOrderDetails(Integer id) {
        Customer customer=customerRespository.findById(id).get();
        CustomerResponse customerdetailreponse=customerDetails(customer);

        List<Orders> OrderList = customer.getOrders();






    }
}
