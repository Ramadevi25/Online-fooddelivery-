package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.respository.OrdersRespository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRespository ordersRespository;

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
        //ordersResponse.setCustomerId(orders.getCustomerId());
        ordersResponse.setDeliveryAddress(orders.getDeliveryAddress());
        return ordersResponse;

    }
}
