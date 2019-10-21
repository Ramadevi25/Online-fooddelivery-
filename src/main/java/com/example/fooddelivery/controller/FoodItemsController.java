package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/fooditems")
public class FoodItemsController {

    @Autowired
    FoodItemsService foodItemsService;

    @GetMapping(value="/fooditems")
    public List<FoodItemsResponse> getFooditems() {
        return foodItemsService.fetchFoodItems();
    }

    @GetMapping(value="/foodname/{food_name}")
    public List<FoodItemsResponse> getFoodItem(@PathVariable("food_name") String food_name){
        return foodItemsService.fetchFoodByName(food_name);
    }
}
