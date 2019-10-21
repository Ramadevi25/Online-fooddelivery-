package com.example.fooddelivery.respository;


import com.example.fooddelivery.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants,Integer> {
}
