package com.example.fooddelivery.service;

import com.example.fooddelivery.model.CardDetails;
import com.example.fooddelivery.model.Cart;
import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.response.CardDetailResponse;
import com.example.fooddelivery.respository.CardDetailRepository;
import com.example.fooddelivery.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardDetailService {
    @Autowired
    private CardDetailRepository cardDetailRepository;

    @Autowired
    private CustomerRespository customerRespository;

    /*public List<CardDetailResponse> fetchCardDetails(Integer customerId) {
        List<CardDetails> cardDetails=cardDetailRepository.findByCustomerId(customerId);
        System.out.println(cardDetails);

        CardDetailResponse cardDetailResponse=new CardDetailResponse();
        List<CardDetailResponse> cardDetailResponses=new ArrayList<>();
        cardDetails.forEach(cardDetail -> {
            CardDetailResponse cardDetailResponse1=getCardDetails(cardDetail);
            cardDetailResponses.add(cardDetailResponse);
        });
        return cardDetailResponses;}
    }*/

public List<CardDetailResponse> fetchCardDetails(Integer customerId) {
    Optional<Customer> customer=customerRespository.findById(customerId);
    if(customer.isPresent()){

        List<CardDetails> cardDetailResponse=cardDetailRepository.findByCustomerId(customer.get().getId());

        System.out.println(cardDetailResponse);
        List<CardDetailResponse> cardDetailResponses=new ArrayList<>();

        cardDetailResponse.forEach(cardDetail -> {
            CardDetailResponse cardDetailResponse1=getCardDetails(cardDetail);
            cardDetailResponses.add(cardDetailResponse1);
        });
        return cardDetailResponses;
    }
    return null;
}

    public CardDetailResponse getCardDetails(CardDetails cardDetails)
    {
        CardDetailResponse cardDetailResponse=new CardDetailResponse();
        cardDetailResponse.setId(cardDetails.getId());
        cardDetailResponse.setCardNo(cardDetails.getCardNo());
        //cardDetailResponse.
        cardDetailResponse.setExpiryDate(cardDetails.getExpiryDate());
        cardDetailResponse.setNameOnCard(cardDetails.getNameOnCard());
        return cardDetailResponse;
    }

    public ResponseEntity<String> insertCardDetails(Integer id, CardDetailResponse cardDetailResponse) {
        Optional<Customer> optionalCustomer = customerRespository.findById(id);
        if(optionalCustomer.isPresent()) {
            CardDetails cardDetails = new CardDetails();
            cardDetails.setCustomer(optionalCustomer.get());
            cardDetails.setCardNo(cardDetailResponse.getCardNo());
            cardDetails.setCustomer(optionalCustomer.get());
            cardDetails.setNameOnCard(cardDetailResponse.getNameOnCard());
            cardDetails.setExpiryDate(cardDetailResponse.getExpiryDate());

            try {
                cardDetailRepository.save(cardDetails);
            }catch (Exception e) {return new ResponseEntity<>("Cant add user", HttpStatus.BAD_REQUEST);}
            return new ResponseEntity<>("Added successfully", HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<String>("Customer id not present in db to add",HttpStatus.BAD_REQUEST);
    }
}
