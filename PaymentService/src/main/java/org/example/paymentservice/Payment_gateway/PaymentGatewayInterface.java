package org.example.paymentservice.Payment_gateway;

import com.stripe.exception.StripeException;

public interface PaymentGatewayInterface {
    String createPaymentLink(long orderId , long amount) throws Exception;

}
