package com.example.fooddelivery.response;

import java.util.List;

public class OrderDetailsResponse {

   // private Integer id;
    private Integer orderId;
    //private Integer foodId;
    //private Integer quantity;


    public List<FoodItemsResponse> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItemsResponse> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    List<FoodItemsResponse> foodItemsList;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

//    public Integer getFoodId() {
//        return foodId;
//    }
//
//    public void setFoodId(Integer foodId) {
//        this.foodId = foodId;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }



}
