package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Restaurants;
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
    RestraurantService restraurantService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping(value="/restaurants")
    public List<RestraurantResponse> getRestraurantDetails() {
        return restraurantService.fetchrestraurantdetails();
    }

    @GetMapping(value="restaurantId/{restraurant_id}")
    public RestraurantResponse getRestraurantById(@PathVariable("restraurant_id") Integer id) {
        return restraurantService.fetchRestraurantById(id);
    }

    @GetMapping("/foodItems/{id}")
    public String foodItems(@PathVariable("id") Integer id) {
        Optional<Restaurants> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()) {
            restaurant.get().getFoodItems().stream().forEach(System.out::println);
        }
        return "Something";

    }




}
