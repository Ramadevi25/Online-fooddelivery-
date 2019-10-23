package com.example.fooddelivery.service;

import com.example.fooddelivery.model.CardDetails;
import com.example.fooddelivery.model.Cart;
import com.example.fooddelivery.response.CardDetailResponse;
import com.example.fooddelivery.respository.CardDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardDetailService {
    @Autowired
    private CardDetailRepository cardDetailRepository;

    public List<CardDetailResponse> fetchCardDetails(Integer customerId) {
        List<CardDetails> cardDetails=cardDetailRepository.findByCustomerId(customerId);
        CardDetailResponse cardDetailResponse=new CardDetailResponse();
        List<CardDetailResponse> cardDetailResponses=new ArrayList<>();
        cardDetails.forEach(cardDetail -> {
            CardDetailResponse cardDetailResponse1=getCardDetails(cardDetail);
            cardDetailResponses.add(cardDetailResponse);
        });
        return cardDetailResponses;
    }
    public CardDetailResponse getCardDetails(CardDetails cardDetails)
    {
        CardDetailResponse cardDetailResponse=new CardDetailResponse();
        cardDetailResponse.setId(cardDetails.getId());
        cardDetailResponse.setCardNo(cardDetails.getCardNo());
        cardDetailResponse.setCustomerId(cardDetails.getCustomerId());
        cardDetailResponse.setExpiryDate(cardDetails.getExpiryDate());
        cardDetailResponse.setNameOnCard(cardDetails.getNameOnCard());
        return cardDetailResponse;
    }
}
