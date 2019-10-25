package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.request.OrderdetailRequest;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.respository.CustomerRespository;
import com.example.fooddelivery.respository.OrderDetailsRespository;
import com.example.fooddelivery.respository.OrdersRespository;
import com.example.fooddelivery.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRespository ordersRespository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private OrderDetailsRespository orderDetailsRespository;

    public List<OrdersResponse> fetchOrders() {
        List<Orders> OrdersDetails=ordersRespository.findAll();
        List<OrdersResponse> orders=new ArrayList<>();
        OrdersDetails.forEach(orders1 -> {
            OrdersResponse ordersResponse=getOrders(orders1);
            orders.add(ordersResponse);
        });
        return orders;

    }
    public OrdersResponse fetchOrderDetail(Integer id) {
        Orders OrdersdetailList=ordersRespository.findById(id).get();
        OrdersResponse orderdetial=getOrders(OrdersdetailList);
            return orderdetial;

    }
    public OrdersResponse getOrders(Orders orders)
    {
        OrdersResponse ordersResponse=new OrdersResponse();
        ordersResponse.setId(orders.getId());
        ordersResponse.setDate(orders.getDate());
        ordersResponse.setTotalprice(orders.getTotalprice());
        return ordersResponse;

    }

    public  OrdersResponse fetchOrders(Integer id) {

        Orders orders=ordersRespository.findById(id).get();
        OrdersResponse ordersResponse=new OrdersResponse();
        ordersResponse.setId(orders.getId());
        ordersResponse.setDate(orders.getDate());
        ordersResponse.setTotalprice(orders.getTotalprice());
        return ordersResponse;
    }

    public List<OrdersResponse> getOrderDetailsByCustomerId(Integer customer_id,Integer totalprice) {
        List<Orders> orders=ordersRespository.findByTotalPrice(customer_id,totalprice);
        List<OrdersResponse> ordersResponseList=new ArrayList<>();
        orders.forEach(order -> {
            OrdersResponse ordersResponse=new OrdersResponse();
            ordersResponse.setId(order.getId());
            ordersResponse.setTotalprice(order.getTotalprice());
            ordersResponse.setDate(order.getDate());
            ordersResponseList.add(ordersResponse);
        });
        return ordersResponseList;
    }

    public String addorder(OrdersResponse ordersResponse) {
        {
            Orders orders=new Orders();
            orders.setCustomer(ordersResponse.getCustomerId());
            orders.setDate(ordersResponse.getDate());
            orders.setTime(ordersResponse.getTime());
            orders.setTotalprice(ordersResponse.getTotalprice());
            ordersRespository.save(orders);

            OrderdetailRequest orderdetailRequest=new OrderdetailRequest();
            orderdetailRequest.setOrderId(orders.getId());
            //orderdetailRequest.setFoodId();
            return "order added";

        }




    }



}
