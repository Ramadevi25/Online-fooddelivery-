package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.model.Payment;
import com.example.fooddelivery.response.OrdersResponse;
import com.example.fooddelivery.response.PaymentResponse;
import com.example.fooddelivery.respository.OrdersRespository;
import com.example.fooddelivery.respository.PaymentRepository;
import org.hibernate.criterion.Order;
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
        ordersResponse.setCustomerId(orders.getCustomerId());
       // ordersResponse.setPaymentType(orders.getPaymentType());
        ordersResponse.setTotalprice(orders.getTotalprice());
        return ordersResponse;

    }

    public  OrdersResponse fetchOrders(Integer id) {

        Orders orders=ordersRespository.findById(id).get();
        OrdersResponse ordersResponse=new OrdersResponse();
        ordersResponse.setId(orders.getId());
        ordersResponse.setDate(orders.getDate());
        //ordersResponse.setPaymentType(orders.getPaymentType());
        ordersResponse.setTotalprice(orders.getTotalprice());
        ordersResponse.setCustomerId(orders.getCustomerId());
//        List<Payment> paymentList = orders.getPayment();
//        List<PaymentResponse> paymentResponseList=new ArrayList<>();
//        paymentList.forEach(payment -> {
//            PaymentResponse paymentResponse=new PaymentResponse();
//            paymentResponse.setId(payment.getId());
//            paymentResponse.setOrderId(payment.getOrderId());
//            paymentResponse.setAmount(payment.getAmount());
//            paymentResponse.setPaymentType(payment.getPaymentType());
//            paymentResponseList.add(paymentResponse);
//
//        });
//        ordersResponse.setPaymentdetail(paymentResponseList);
        return ordersResponse;
    }

    public List<OrdersResponse> getOrderDetailsByCustomerId(Integer customer_id,Integer totalprice) {
        List<Orders> orders=ordersRespository.findByTotalPrice(customer_id,totalprice);
        List<OrdersResponse> ordersResponseList=new ArrayList<>();
        orders.forEach(order -> {
            OrdersResponse ordersResponse=new OrdersResponse();
            ordersResponse.setId(order.getId());
            ordersResponse.setCustomerId(order.getCustomerId());
            ordersResponse.setTotalprice(order.getTotalprice());
            ordersResponse.setDate(order.getDate());
            ordersResponseList.add(ordersResponse);
        });
        return ordersResponseList;
    }

}
