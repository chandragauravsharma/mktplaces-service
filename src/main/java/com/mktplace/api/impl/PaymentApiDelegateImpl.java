package com.mktplace.api.impl;

import com.mktplace.api.PaymentApiDelegate;
import com.mktplace.model.PaymentCallbackRequest;
import com.mktplace.model.PaymentCallbackResponse;
import com.mktplace.model.PaymentRequest;
import com.mktplace.model.PaymentResponse;
import com.mktplace.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class PaymentApiDelegateImpl implements PaymentApiDelegate {
    @Autowired
    PaymentService paymentService;

    @Override
    public Mono<ResponseEntity<PaymentResponse>> pay(Mono<PaymentRequest> paymentRequest, ServerWebExchange exchange) {
        return PaymentApiDelegate.super.pay(paymentRequest, exchange);
    }

    @Override
    public Mono<ResponseEntity<PaymentCallbackResponse>> paycallback(Mono<PaymentCallbackRequest> paymentCallbackRequest, ServerWebExchange exchange) {
        return paymentService.paycallback(paymentCallbackRequest)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
