package com.example.fooddelivery.controller;

import com.example.fooddelivery.request.FoodItemsRequest;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/fooditems")
public class FoodItemsController {

    @Autowired
    private FoodItemsService foodItemsService;

    @GetMapping("/fooditems")
    public List<FoodItemsResponse> getFooditems() {
        return foodItemsService.fetchFoodItems();
    }

    @GetMapping(value="/{food_name}")
    public List<FoodItemsResponse> getFoodItem(@PathVariable("food_name") String food_name){
        return foodItemsService.fetchFoodByName(food_name);
    }
    @PostMapping(value="/addFoodItem")
    public void addFoodItems(@RequestBody FoodItemsRequest foodItemsRequest){
        foodItemsService.insertFooditems(foodItemsRequest);
    }

}
