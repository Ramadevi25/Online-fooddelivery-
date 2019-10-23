package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Restaurants;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.RestaurantRepository;
import com.example.fooddelivery.service.RestraurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {
    @Autowired
    private RestraurantService restraurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(value="/restaurants")
    public List<RestraurantResponse> getRestraurantDetails() {
        return restraurantService.fetchrestraurantdetails();
    }

    @GetMapping(value="restaurant/{restraurantId}")
    public RestraurantResponse getRestraurantById(@PathVariable("restraurantId") Integer id) {
        return restraurantService.fetchRestraurantById(id);
    }

    @GetMapping("/restaurant/fooditems/{restaurantId}")
    public List<FoodItemsResponse> foodItems(@PathVariable("restaurantId") Integer id) {
        return restraurantService.fooddetails(id);

    }

}
