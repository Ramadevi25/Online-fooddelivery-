package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.CartResponse;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
