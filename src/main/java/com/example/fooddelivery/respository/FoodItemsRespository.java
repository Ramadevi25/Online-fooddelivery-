package com.example.fooddelivery.respository;

import com.example.fooddelivery.model.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemsRespository extends JpaRepository<FoodItems,Integer> {
    List<FoodItems> findByFoodName(String food_name);
}
