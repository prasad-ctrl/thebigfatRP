package org.example.paymentservice.service;

import org.example.paymentservice.Payment_gateway.PaymentGatewayInterface;
import org.example.paymentservice.Payment_gateway.Stripepaymentgateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentGatewayInterface pgi; //= new Stripepaymentgateway();
    @Override
    public String createPaymentLink(long orderId) throws Exception {



        // call GET/orders/{orderId} and fetch order info
        long amount = 1000;
        return pgi.createPaymentLink( orderId , amount);

    }
}
