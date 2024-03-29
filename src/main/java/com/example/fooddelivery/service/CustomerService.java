package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.request.CustomerRequest;
import com.example.fooddelivery.response.CustomerDetailResponse;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private static Logger logger= LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRespository customerRespository;

    public List<CustomerDetailResponse> fetchCustomersDetails()
    {
        List<Customer> customers=customerRespository.findAll();
        List<CustomerDetailResponse> customerdetails = new ArrayList<>();
        customers.forEach(customer ->
        {
            CustomerDetailResponse customerDetailResponse=customerDetails(customer);
            customerdetails.add(customerDetailResponse);
        });
       return customerdetails;
    }
    public CustomerDetailResponse fetchCustomerById(Integer id) {
        Customer customerdetail=customerRespository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
        CustomerDetailResponse customerDetailResponse=customerDetails(customerdetail);
        logger.info("Customer Object {}",customerdetail);
        return customerDetailResponse;
    }

    public CustomerDetailResponse customerDetails(Customer customerdetail){
        CustomerDetailResponse customer=new CustomerDetailResponse();
        customer.setId(customerdetail.getId());
        customer.setName(customerdetail.getName());
        customer.setAddress(customerdetail.getAddress());
        customer.setEmail(customerdetail.getEmail());
        customer.setMobileNo(customerdetail.getMobileNo());
        customer.setUsername(customerdetail.getUsername());
        customer.setPassword(customerdetail.getPassword());
        return customer;
    }

    public CustomerResponse fetchCustomerOrders(Integer id) {
        Customer customer=customerRespository.findById(id).get();
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setMobileNo(customer.getMobileNo());
        customerResponse.setEmail(customer.getEmail());

        List<Orders> OrderList = customer.getOrders();
        List<OrdersResponse> ordersResponses=new ArrayList<>();
        OrderList.forEach(orders -> {
            OrdersResponse ordersResponse=new OrdersResponse();
            ordersResponse.setId(orders.getId());
            ordersResponse.setDate(orders.getDate());
            ordersResponse.setTotalprice(orders.getTotalprice());
            ordersResponses.add(ordersResponse);
        });
        customerResponse.setOrderdetails(ordersResponses);
    return customerResponse;
    }


    public ResponseEntity addCustomerDetails(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        customer.setName(customerRequest.getName());
        customer.setUsername(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customer.setMobileNo(customerRequest.getMobileNo());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        try{
            customerRespository.save(customer);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }
        catch(DataAccessException ex)
        {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }

    }
    public void updateCustomerById(CustomerRequest customerRequest) {
       Optional<Customer> customer = customerRespository.findById(customerRequest.getId());
       customer.get().setAddress(customerRequest.getAddress());
       customer.get().setEmail(customerRequest.getEmail());
       customerRespository.save(customer.get());
    }

    public String checkCustomer(String username, String password) {
        Customer customer=customerRespository.findByUsername(username);
        if(customer.getUsername().equals(username) && customer.getPassword().equals(password))
        {
            return "successfully logged in";
        }
        return "invalid login";

    }
}
