package com.mktplace.service;

import com.mktplace.model.Payment;
import com.mktplace.model.PaymentCallbackRequest;
import com.mktplace.model.PaymentCallbackResponse;
import com.mktplace.model.dto.BookingDTO;
import com.mktplace.repository.BookingRepository;
import com.mktplace.repository.ProductRepository;
import com.mktplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final UserRepository userRepository;

    public PaymentService(BookingRepository bookingRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Mono<PaymentCallbackResponse> paycallback(Mono<PaymentCallbackRequest> paymentCallbackRequest) {
        return paymentCallbackRequest.flatMap(request -> {
            if (request.getStatus() == PaymentCallbackRequest.StatusEnum.SUCCESS) {
                return bookingRepository.findById(request.getBookingId())
                        .flatMap(booking -> {
                            if (booking.getStatus() != BookingDTO.StatusEnum.HOLD) {
                                return constructFailureResponse();
                            }

                            // update booking status, update product (remove hold and update sold_out), update user's last purchase timestamp
                            return bookingRepository.updateBookingStatus(request.getBookingId(), BookingDTO.StatusEnum.BOOKED)
                                    .flatMap(rowsUpdated -> {
                                        if (rowsUpdated == 1) {
                                            return productRepository.updateProductQuantitiesForSoldOut(booking.getProductId(), booking.getSellerId())
                                                    .flatMap(rowsUpdated1 -> {
                                                        if (rowsUpdated1 == 1) {
                                                            return userRepository.updateUserLastPurchaseTime(LocalDateTime.now(), booking.getBuyerId())
                                                                    .flatMap(rowsUpdated2 -> {
                                                                        if (rowsUpdated2 == 1) {
                                                                            PaymentCallbackResponse paymentCallbackResponse = new PaymentCallbackResponse();
                                                                            paymentCallbackResponse.setStatus(PaymentCallbackResponse.StatusEnum.SUCCESS);
                                                                            Payment payment = new Payment();
                                                                            payment.setPaymentId(request.getPaymentId());
                                                                            payment.setBookingId(request.getBookingId());
                                                                            paymentCallbackResponse.setPayment(payment);
                                                                            return Mono.just(paymentCallbackResponse);
                                                                        } else {
                                                                            // rollback and handle exceptions here
                                                                            return constructFailureResponse();
                                                                        }
                                                                    });
                                                        } else {
                                                            // rollback booking and handle exception here
                                                            return constructFailureResponse();
                                                        }
                                                    });
                                        } else {
                                            return constructFailureResponse();
                                        }
                                    });
                        });
            } else {
                // handle other scenarios for payment's other status
                return Mono.empty();
            }
        });
    }

    private Mono<PaymentCallbackResponse> constructFailureResponse() {
        PaymentCallbackResponse failureResponse = new PaymentCallbackResponse();
        failureResponse.setStatus(PaymentCallbackResponse.StatusEnum.FAILURE);

        return Mono.just(failureResponse);
    }
}
