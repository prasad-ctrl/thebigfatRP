package org.example.paymentservice.service;

public interface PaymentService {
    String createPaymentLink(long orderId) throws Exception;

}
