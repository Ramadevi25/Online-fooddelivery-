package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Restaurants;
import com.example.fooddelivery.response.RestraurantResponse;
import com.example.fooddelivery.respository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RestraurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

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

    }

