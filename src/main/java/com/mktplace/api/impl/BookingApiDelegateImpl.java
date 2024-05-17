package com.mktplace.api.impl;

import com.mktplace.api.BookingApiDelegate;
import com.mktplace.model.*;
import com.mktplace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Controller
public class BookingApiDelegateImpl implements BookingApiDelegate {
    @Autowired
    BookingService bookingService;

    @Override
    public Mono<ResponseEntity<CheckoutResponse>> checkout(Mono<CheckoutRequest> checkoutRequest, ServerWebExchange exchange) {
        return bookingService.checkout(checkoutRequest)
                .map(checkoutResponse -> ResponseEntity.status(HttpStatus.OK).body(checkoutResponse))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public Mono<ResponseEntity<BookingResponse>> book(Mono<BookingRequest> bookingRequest, ServerWebExchange exchange) {
        return bookingService.book(bookingRequest)
                .map(bookingResponse -> ResponseEntity.status(HttpStatus.OK).body(bookingResponse))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public Mono<ResponseEntity<Booking>> getBookingById(Long bookingId, ServerWebExchange exchange) {
        return bookingService.getBookingById(bookingId)
                .map(bookingResponse -> ResponseEntity.status(HttpStatus.OK).body(bookingResponse))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
