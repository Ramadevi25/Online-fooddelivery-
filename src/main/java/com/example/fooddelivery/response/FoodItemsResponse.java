package com.example.fooddelivery.response;

public class FoodItemsResponse {

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRestraurantId() {
        return restraurantId;
    }

    public void setRestraurantId(Integer restraurantId) {
        this.restraurantId = restraurantId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String foodName;
    private Double price;
    private Integer restraurantId;

    }
