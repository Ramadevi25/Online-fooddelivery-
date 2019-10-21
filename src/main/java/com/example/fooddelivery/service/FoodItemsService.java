package com.example.fooddelivery.service;

import com.example.fooddelivery.model.FoodItems;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.respository.FoodItemsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodItemsService {
    @Autowired
    FoodItemsRespository foodItemsRespository;

    public List<FoodItemsResponse> fetchFoodItems() {
        List<FoodItems> foodItemsList=foodItemsRespository.findAll();
        List<FoodItemsResponse> foodItems=new ArrayList<>();
        foodItemsList.forEach(fooditems -> {
            FoodItemsResponse foodItemsResponse=getFoodItems(fooditems);
            foodItems.add(foodItemsResponse);
        });
        return foodItems;
    }

   public List<FoodItemsResponse> fetchFoodByName(String food_name) {
        List<FoodItems> foodItem = foodItemsRespository.findByFoodName(food_name);
        List<FoodItemsResponse> fooditem = new ArrayList<FoodItemsResponse>();

            foodItem.forEach(fooditemsList -> {
                FoodItemsResponse foodItemsResponse=getFoodItems(fooditemsList);
                fooditem.add(foodItemsResponse);
            });
            return fooditem;
        }
        public FoodItemsResponse getFoodItems(FoodItems foodItems)
        {
            FoodItemsResponse foodItemsResponse=new FoodItemsResponse();
            foodItemsResponse.setId(foodItems.getId());
            foodItemsResponse.setFoodName(foodItems.getFoodName());
            foodItemsResponse.setPrice(foodItems.getPrice());
            //foodItemsResponse.setRestraurantId(foodItems.getRestaurantId());
            return foodItemsResponse;
        }

    }

