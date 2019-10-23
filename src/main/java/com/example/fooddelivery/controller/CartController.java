package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.CartResponse;
import com.example.fooddelivery.response.CustomerResponse;
import com.example.fooddelivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping(value="cartdetail/{customerId}")
    public CartResponse getCartDetails(@PathVariable("customerId") Integer id ){
        return cartService.fetchCartDetails(id);
    }

}
