package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.request.CustomerRequest;
import com.example.fooddelivery.response.CustomerDetailResponse;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
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

    public CustomerResponse fetchCustomerOrderDetails(Integer id) {
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
            //ordersResponse.setCustomerId(orders.getCustomerId());
            ordersResponses.add(ordersResponse);
        });
        customerResponse.setOrderdetails(ordersResponses);
    return customerResponse;
    }

    public CustomerDetailResponse fetchOrder(Integer customerId) {
        Optional<Customer> customer=customerRespository.findById(customerId);
        CustomerDetailResponse customerResponse=new CustomerDetailResponse();
        customerResponse.setId(customer.get().getId());
        customerResponse.setName(customer.get().getName());
        customerResponse.setEmail(customer.get().getEmail());
        return customerResponse;
    }


    public void addCustomerDetails(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        customer.setName(customerRequest.getName());
        customer.setUsername(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customer.setMobileNo(customerRequest.getMobileNo());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        customerRespository.save(customer);
    }
}
