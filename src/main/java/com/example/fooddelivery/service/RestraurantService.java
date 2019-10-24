package com.example.fooddelivery.service;

import com.example.fooddelivery.model.FoodItems;
import com.example.fooddelivery.model.Restaurants;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RestraurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestraurantResponse fetchRestraurantById(Integer id) {
        Restaurants restraurants= restaurantRepository.findById(id).get();
        RestraurantResponse restraurant=restraurantdetails(restraurants);
        return  restraurant;
    }

    public  List<RestraurantResponse> fetchrestraurantdetails() {
        List<Restaurants> restraurantResponses= restaurantRepository.findAll();
        List<RestraurantResponse> restraurantdetails=new ArrayList<>();
        restraurantResponses.forEach(restraurants -> {
            RestraurantResponse restraurantResponse=restraurantdetails(restraurants);
            restraurantdetails.add(restraurantResponse);
        });
        return restraurantdetails;
    }

    public RestraurantResponse restraurantdetails(Restaurants restraurants)
    {
        RestraurantResponse restraurantResponse=new RestraurantResponse();
        restraurantResponse.setId(restraurants.getId());
        restraurantResponse.setName(restraurants.getName());
        return restraurantResponse;
        }

    public List<FoodItemsResponse> fooddetails(Integer id) {
        Optional<Restaurants> restaurant = restaurantRepository.findById(id);
        List<FoodItems> restraurantResponses=restaurant.get().getFoodItems();
        List<FoodItemsResponse> foodItemsResponsesList=new ArrayList<>();
        restraurantResponses.forEach(foodItems -> {
            FoodItemsResponse foodItemsResponse=new FoodItemsResponse();
                foodItemsResponse.setId(foodItems.getId());
                foodItemsResponse.setFoodName(foodItems.getFoodName());
                foodItemsResponse.setPrice(foodItems.getPrice());
                foodItemsResponsesList.add(foodItemsResponse);

            });
        return foodItemsResponsesList;
        }


    public void addRestaurantDetail(RestraurantResponse restraurantResponse) {
        Restaurants restaurants=new Restaurants();
        restaurants.setId(restraurantResponse.getId());
        restaurants.setName(restraurantResponse.getName());
        restaurantRepository.save(restaurants);
    }

    public void deleteRestaurantId(Integer id) {
        restaurantRepository.deleteById(id);
    }
}

