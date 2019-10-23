package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.CardDetailResponse;
import com.example.fooddelivery.service.CardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class CardDetailsController {
    @Autowired
    private CardDetailService cardDetailService;

    @GetMapping(value="/cardetails/{customerId}")
    public List<CardDetailResponse> getCardDetails(@PathVariable("customerId") Integer customerId)
    {
        return cardDetailService.fetchCardDetails(customerId);
    }

}
