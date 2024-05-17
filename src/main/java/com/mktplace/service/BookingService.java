package com.mktplace.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mktplace.model.*;
import com.mktplace.model.dto.BookingDTO;
import com.mktplace.repository.BookingRepository;
import com.mktplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class BookingService {
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public BookingService(BookingRepository bookingRepository, ProductRepository productRepository, ObjectMapper objectMapper) {
        this.bookingRepository = bookingRepository;
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    public Mono<CheckoutResponse> checkout(Mono<CheckoutRequest> checkoutRequest) {
        // Order/booking creation
        // validate if the seller owns this product
        // and if the available_quantity > 0
        // and buyer exists in the system
        // + other conditions
        return checkoutRequest.flatMap(request -> {
            // check if user can do this booking
            // since a user is allowed to buy only one item in a month
            return bookingRepository.findBookingsByBuyerIdInLastMonth(request.getBuyerId(), LocalDateTime.now().minusMonths(1))
                    .flatMap(rows -> {
                        if (rows > 1) {
                            CheckoutResponse failureResponse = new CheckoutResponse();
                            failureResponse.setStatus(CheckoutResponse.StatusEnum.FAILURE);
                            return Mono.just(failureResponse);
                        }
                        BookingDTO bookingDTO = new BookingDTO();
                        bookingDTO.setBuyerId(request.getBuyerId());
                        bookingDTO.setSellerId(request.getSellerId());
                        bookingDTO.setProductId(request.getProductId());
                        bookingDTO.setTransactionAmount(request.getTransactionAmount());
                        bookingDTO.setStatus(BookingDTO.StatusEnum.CREATED);

                        return bookingRepository.save(bookingDTO)
                                .map(createdBooking -> {
                                    CheckoutResponse response = new CheckoutResponse();
                                    response.setStatus(CheckoutResponse.StatusEnum.SUCCESS);
                                    response.setBooking(objectMapper.convertValue(createdBooking, Booking.class));
                                    return response;
                                });
                    });
        });
    }

    public Mono<BookingResponse> book(Mono<BookingRequest> bookingRequest) {
        return bookingRequest.flatMap(request -> {
            // validate booking id (similarly validate other params as well)
            if (request.getBookingId() == null) {
                return Mono.just(constructFailureResponse());
            }

            // put hold on product item
            return bookingRepository.findById(request.getBookingId())
                    .flatMap(booking -> {
                        if (booking.getStatus() != BookingDTO.StatusEnum.CREATED) {
                            return Mono.just(constructFailureResponse());
                        }
                        return productRepository.updateProductQuantitiesForHold(request.getProductId(), request.getSellerId())
                                .flatMap(holdResponse -> {
                                    // if hold is success, update booking status and return success
                                    // else return failure
                                    if (holdResponse == 1) {
                                        // 1 row updated
                                        return bookingRepository.updateBookingStatus(request.getBookingId(), BookingDTO.StatusEnum.HOLD)
                                                .flatMap(updatedRows -> {
                                                    if (updatedRows == 1) {
                                                        return bookingRepository.findById(request.getBookingId())
                                                                .map(res -> {
                                                                    BookingResponse response = new BookingResponse();
                                                                    response.setStatus(BookingResponse.StatusEnum.SUCCESS);
                                                                    response.setBooking(constructBookingResponse(res));
                                                                    return response;
                                                                });
                                                    } else {
                                                        return Mono.just(constructFailureResponse());
                                                    }
                                                });
                                    } else {
                                        // failure, 0 rows updated
                                        return Mono.just(constructFailureResponse());
                                    }
                                });
                    });
        });
    }

    public Mono<Booking> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .map(r -> constructBookingResponse(r));
    }

    private Booking constructBookingResponse(BookingDTO res) {
        Booking booking = new Booking();
        booking.setBookingId(res.getBookingId());
        booking.setBuyerId(res.getBuyerId());
        booking.setSellerId(res.getSellerId());
        booking.setProductId(res.getProductId());
        booking.setTransactionAmount(res.getTransactionAmount());
        booking.setPaymentId(res.getPaymentId());
        switch (res.getStatus()) {
            case CREATED -> booking.setStatus(Booking.StatusEnum.CREATED);
            case BOOKED -> booking.setStatus(Booking.StatusEnum.BOOKED);
            case REFUNDED -> booking.setStatus(Booking.StatusEnum.REFUNDED);
            case CANCELLED -> booking.setStatus(Booking.StatusEnum.CANCELLED);
            case HOLD -> booking.setStatus(Booking.StatusEnum.HOLD);
        }

        return booking;
    }

    private BookingResponse constructFailureResponse() {
        BookingResponse failureResponse = new BookingResponse();
        failureResponse.setStatus(BookingResponse.StatusEnum.FAILURE);

        return failureResponse;
    }
}
