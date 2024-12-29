package org.example.paymentservice.Payment_gateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Stripepaymentgateway implements PaymentGatewayInterface{
  

    @Value("${Stripe.secret.key}")
    private String StripeSecretKey ;


    @Override
    public String createPaymentLink(long orderId, long amount) throws StripeException {
        // going to call stripe to do our payment
        // order service will give order Id , get product id , then from stripe get price ID

        Stripe.apiKey =StripeSecretKey; // "sk_test_51QNHE9FDH9EBtN6YrS47gMRWgQ0rNJYwU74MFDRDwdLmr1Kn2TdaBd1KYTbaS8ozD7hfEVTWlm1ammg7UqDjqzo200xcT2aftw";
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1QNHGVFDH9EBtN6YUwJRGcY2")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(
                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                .setUrl("https://scaler.com")
                                                .build()
                                ).build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
    }
}
