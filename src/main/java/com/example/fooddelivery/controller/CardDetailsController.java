package com.example.fooddelivery.controller;

import com.example.fooddelivery.response.CardDetailResponse;
import com.example.fooddelivery.service.CardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carddetails")
public class CardDetailsController {
    @Autowired
    private CardDetailService cardDetailService;

    @GetMapping(value="/{customerId}")
    public List<CardDetailResponse> getCardDetails(@PathVariable("customerId") Integer customerId)
    {
        return cardDetailService.fetchCardDetails(customerId);
    }
    @PostMapping(value="/addcarddetail/{id}")
    public ResponseEntity<String> addCarddetails(@PathVariable("id")Integer id, @RequestBody CardDetailResponse cardDetailResponse)
    {
        return cardDetailService.insertCardDetails(id,cardDetailResponse);
    }


}
