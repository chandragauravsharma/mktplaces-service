package com.mktplace.api;

import com.mktplace.model.BookingRequest;
import com.mktplace.model.BookingResponse;
import com.mktplace.model.CheckoutRequest;
import com.mktplace.model.CheckoutResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link BookingApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface BookingApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /book : Update booking to BOOKED state, put hold on product and wait for payment to be done
     *
     * @param bookingRequest  (required)
     * @return checkout done and booking id generated (status code 200)
     *         or Internal server error (status code 500)
     * @see BookingApi#book
     */
    default Mono<ResponseEntity<BookingResponse>> book(Mono<BookingRequest> bookingRequest,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"booking\" : { \"booking_id\" : 0, \"createdAt\" : 7, \"payment_id\" : 2, \"product_id\" : 5, \"transaction_amount\" : 5.637376656633329, \"buyer_id\" : 6, \"seller_id\" : 1, \"status\" : \"created\", \"updatedAt\" : 9 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(bookingRequest).then(Mono.empty());

    }

    /**
     * POST /checkout : Create a new booking with a unique id in CREATED state
     *
     * @param checkoutRequest  (required)
     * @return checkout done and booking id generated (status code 200)
     *         or Internal server error (status code 500)
     * @see BookingApi#checkout
     */
    default Mono<ResponseEntity<CheckoutResponse>> checkout(Mono<CheckoutRequest> checkoutRequest,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"booking\" : { \"booking_id\" : 0, \"createdAt\" : 7, \"payment_id\" : 2, \"product_id\" : 5, \"transaction_amount\" : 5.637376656633329, \"buyer_id\" : 6, \"seller_id\" : 1, \"status\" : \"created\", \"updatedAt\" : 9 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(checkoutRequest).then(Mono.empty());

    }

}
