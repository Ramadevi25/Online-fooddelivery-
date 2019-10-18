package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRespository customerRespository;
    public List<CustomerResponse> fetchcustomersdetails()
    {
        List<Customer> customers=customerRespository.findAll();
        List<CustomerResponse> customerdetails = new ArrayList<>();
        customers.forEach(customer ->
        {
            CustomerResponse customerresponse=new CustomerResponse();
            customerresponse.setId(customer.getId());
            customerresponse.setName(customer.getName());
            customerresponse.setAddress(customer.getAddress());
            customerresponse.setEmail(customer.getEmail());
            customerresponse.setPhone(customer.getPhone());
            customerdetails.add(customerresponse);
        });
       return customerdetails;
    }
    public CustomerResponse fetchCustomerById(Integer id) {
        Optional<Customer> customerdetail=customerRespository.findById(id);
        customerdetail.orElseThrow(()-> new CustomerNotFoundException(id));
        CustomerResponse customer=customerdetails(customerdetail);
        return customer;
    }
    public CustomerResponse customerdetails(Optional<Customer> customerdetail){
        CustomerResponse customer=new CustomerResponse();
        customer.setId(customerdetail.get().getId());
        customer.setName(customerdetail.get().getName());
        customer.setAddress(customerdetail.get().getAddress());
        customer.setEmail(customerdetail.get().getEmail());
        customer.setPhone(customerdetail.get().getPhone());
        return customer;
    }
}
