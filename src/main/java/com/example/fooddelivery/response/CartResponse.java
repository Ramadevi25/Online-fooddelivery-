package com.example.fooddelivery.response;

import com.example.fooddelivery.model.FoodItems;

import java.util.List;

public class CartResponse {
    private Integer customerId;



    List<FoodItemsResponse> foodDetails;

    public List<FoodItemsResponse> getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(List<FoodItemsResponse> foodDetails) {
        this.foodDetails = foodDetails;
    }

    @Override
    public String toString() {
        return "CartResponse{" +
                "customerId=" + customerId +
                ", foodDetails=" + foodDetails +
                '}';
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }



}
