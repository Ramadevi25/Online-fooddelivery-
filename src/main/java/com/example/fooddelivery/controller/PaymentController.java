package com.example.fooddelivery.controller;
import com.example.fooddelivery.response.PaymentResponse;
import com.example.fooddelivery.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value="/paymentdetail/{orderId}")
    public PaymentResponse getPaymentDetail(@PathVariable("orderId")Integer orderId)
    {
        return paymentService.fetchPaymentDetail(orderId);
    }

}
