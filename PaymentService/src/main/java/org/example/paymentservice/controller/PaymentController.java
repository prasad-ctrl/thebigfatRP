package org.example.paymentservice.controller;

import org.example.paymentservice.dto.CreatePaymentLinkRequestDto;
import org.example.paymentservice.dto.CreatePaymentLinkResposeDto;
import org.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
private  PaymentService paymentService;
    @PostMapping("/paymentLink")
    public ResponseEntity<CreatePaymentLinkResposeDto> createPaymentLink(@RequestBody CreatePaymentLinkRequestDto requestDto){
        try{
            String url =paymentService.createPaymentLink(requestDto.getOrderId());
            CreatePaymentLinkResposeDto responseDto = new CreatePaymentLinkResposeDto();
            responseDto.setPaymentLinkurl(url);
            return ResponseEntity.ok(responseDto);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }



    }

}
