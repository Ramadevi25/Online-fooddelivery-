package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Restaurants;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.RestaurantRepository;
import com.example.fooddelivery.service.RestraurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @PostMapping("/addrestaurant")
    public void addRestaurantDetails(@RequestBody RestraurantResponse restraurantResponse)
    {
        restraurantService.addRestaurantDetail(restraurantResponse);
    }
    @DeleteMapping("/{restaurantId}")
    public void removeRestaurant(@PathVariable("restaurantId")Integer id)
    {
        restraurantService.deleteRestaurantId(id);
    }




}
