package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Cart;
import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.FoodItems;
import com.example.fooddelivery.model.Restaurants;
import com.example.fooddelivery.request.CartOrderdetail;
import com.example.fooddelivery.request.CartRequest;
import com.example.fooddelivery.response.CartResponse;
import com.example.fooddelivery.response.FoodItemsResponse;
import com.example.fooddelivery.respository.CartRepository;
import com.example.fooddelivery.respository.CustomerRespository;
import com.example.fooddelivery.respository.FoodItemsRespository;
import com.example.fooddelivery.respository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private FoodItemsRespository foodItemsRespository;
    @Autowired
    private CustomerRespository customerRespository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<CartResponse> fetchCartDetails() {

        List<Cart> cartdetails = cartRepository.findAll();
        List<CartResponse> cartdetaillist = new ArrayList<>();
        cartdetails.forEach(cart ->
        {
            CartResponse cartResponse = new CartResponse();
            //cartResponse.setCustomerId(cart.getCustomerId());
            cartdetaillist.add(cartResponse);
        });
        return cartdetaillist;

    }

    public CartResponse fetchCartDetails(Integer id) {
        List<Cart> cartList = cartRepository.findByCustomerId(id);

        System.out.println(cartList);
        if (!cartList.isEmpty()) {

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

    public CartResponse getCartDetails(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        return cartResponse;

    }

    public void deleteCartDetails() {
        cartRepository.deleteAll();
    }

    public void deleteFoodItem(Integer id) {
        Cart cart = cartRepository.findByfoodId(id);
        cartRepository.delete(cart);
    }
    public ResponseEntity addCarditems(CartRequest cartrequest) {
        Optional<Customer> customer = customerRespository.findById(cartrequest.getCustomerId());
        Optional<FoodItems> foodItems = foodItemsRespository.findById(cartrequest.getFoodId());
        Optional<Restaurants> restaurant = restaurantRepository.findById(cartrequest.getRestaurantId());
        if (customer.isPresent() & foodItems.isPresent() & restaurant.isPresent()) {

            Cart cart = new Cart();
            cart.setCustomerId(customer.get().getId());
            cart.setRestaurantId(cartrequest.getRestaurantId());
            cart.setFoodId(cartrequest.getFoodId());
            try {
                cartRepository.save(cart);
                return new ResponseEntity<String>("item added", HttpStatus.CREATED);

            } catch (Exception ex) {
                new ResponseEntity<String>("cart details not saves", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<String>("cart details not saves", HttpStatus.BAD_REQUEST);

    }
}
