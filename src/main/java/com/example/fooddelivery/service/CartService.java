package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Cart;
import com.example.fooddelivery.model.FoodItems;
import com.example.fooddelivery.response.CartResponse;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.respository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<CartResponse> fetchCartDetails() {

        List<Cart> cartdetails=cartRepository.findAll();
        List<CartResponse> cartdetaillist=new ArrayList<>();
        cartdetails.forEach(cart ->
        {
            CartResponse cartResponse=new CartResponse();
            cartResponse.setCustomerId(cart.getCustomerId());
            cartdetaillist.add(cartResponse);
        });
        return cartdetaillist;

    }

    public CartResponse fetchCartDetails(Integer id) {
        List<Cart> cartList=cartRepository.findByCustomerId(id);


        System.out.println(cartList);
        if(!cartList.isEmpty()) {

            List<FoodItemsResponse> foodItemsResponses = new ArrayList<>();

            CartResponse cartResponse = new CartResponse();
            cartResponse.setCustomerId(id);

            cartList.forEach(cart -> {
                FoodItemsResponse foodItemsResponse = new FoodItemsResponse();
                cart.getFoodItemsList().forEach(foodItems -> {
                    foodItemsResponse.setId(foodItems.getId());
                    foodItemsResponse.setFoodName(foodItems.getFoodName());
                    foodItemsResponse.setPrice(foodItems.getPrice());
                    foodItemsResponses.add(foodItemsResponse);
                });
                cartResponse.setFoodDetails(foodItemsResponses);
            });
            return cartResponse;
        }
        return null;
    }
    public CartResponse getCartDetails(Cart cart)
    {
        CartResponse cartResponse=new CartResponse();
        cartResponse.setCustomerId(cart.getCustomerId());
        return cartResponse;

    }
}
