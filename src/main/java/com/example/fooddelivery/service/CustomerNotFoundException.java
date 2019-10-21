package com.example.fooddelivery.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException {
    private static final Logger logger= LoggerFactory.getLogger(CustomerNotFoundException.class);
    public CustomerNotFoundException(Integer id) {
        super("Customer id not found : " +id );
        logger.info("Customer id not found : " +id);


    }

}
