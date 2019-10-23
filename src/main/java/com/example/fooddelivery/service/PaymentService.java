package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Payment;
import com.example.fooddelivery.response.PaymentResponse;
import com.example.fooddelivery.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
     @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse fetchPaymentDetail(Integer orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId);
        PaymentResponse paymentResponse=new PaymentResponse();
        paymentResponse.setId(payment.getId());
        paymentResponse.setOrderId(payment.getOrderId());
        paymentResponse.setPaymentType(payment.getPaymentType());
        paymentResponse.setAmount(payment.getAmount());
        return paymentResponse;
    }
    public PaymentResponse getPayment (Payment payment)
    {
        PaymentResponse paymentResponse=new PaymentResponse();
        paymentResponse.setId(payment.getId());
        paymentResponse.setOrderId(payment.getOrderId());
        paymentResponse.setAmount(payment.getAmount());
        paymentResponse.setPaymentType(payment.getPaymentType());
        return paymentResponse;
    }
}
