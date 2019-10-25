package com.example.fooddelivery.controller;

import com.example.fooddelivery.request.CartRequest;
import com.example.fooddelivery.request.FoodItemsRequest;
import com.example.fooddelivery.response.CartResponse;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.respository.CartRepository;
import com.example.fooddelivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping(value="cartdetail/{customerId}")
    public CartResponse getCartDetails(@PathVariable("customerId") Integer id ){
        return cartService.fetchCartDetails(id);
    }
    @DeleteMapping(value={"/cartdetails"})
    public void removeCartDetails()
    {
        cartService.deleteCartDetails();

    }
    @DeleteMapping("/{foodId}")
    public void removeFoodItem(@PathVariable("foodId")Integer id)
    {
        cartService.deleteFoodItem(id);
    }
    @PostMapping("/insertcartdetails")
    public ResponseEntity<String> insertCartitems(@RequestBody CartRequest cartRequest)
    {
        return cartService.addCarditems(cartRequest);
    }





}
