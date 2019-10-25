package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Orderdetails;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.response.OrderDetailsResponse;
import com.example.fooddelivery.respository.OrderDetailsRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
   private  OrderDetailsRespository orderDetailsRespository;


    public OrderDetailsResponse fetchOrderDetailById(Integer id)
    {

       List<Orderdetails> orderdetails=orderDetailsRespository.findByOrderId(id);
       List<FoodItemsResponse> foodItemsResponses=new ArrayList<>();
       OrderDetailsResponse orderDetailsResponse=new OrderDetailsResponse();
        orderdetails.forEach(orderdetail -> {
            orderDetailsResponse.setOrderId(orderdetail.getOrderId());
        });
        orderdetails.forEach(orderdetails1 -> {
            FoodItemsResponse foodItemsResponse=new FoodItemsResponse();
            orderdetails1.getFoodItemsList().forEach(foodItemResponse -> {
                System.out.println(orderdetails1.getFoodItemsList());
                foodItemsResponse.setId(foodItemResponse.getId());
                foodItemsResponse.setFoodName(foodItemResponse.getFoodName());
                foodItemsResponse.setPrice(foodItemResponse.getPrice());
                foodItemsResponses.add(foodItemsResponse);
            });
            orderDetailsResponse.setFoodItemsList(foodItemsResponses);
        });
        return orderDetailsResponse;
    }
    public OrderDetailsResponse getOrdersResponse(Orderdetails orderdetails)
    {
        OrderDetailsResponse orderDetailsResponse=new OrderDetailsResponse();
        orderDetailsResponse.setOrderId(orderdetails.getOrderId());
        return orderDetailsResponse;
    }
}


