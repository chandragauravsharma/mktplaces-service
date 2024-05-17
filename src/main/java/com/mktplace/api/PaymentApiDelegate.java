package com.mktplace.api;

import com.mktplace.model.PaymentCallbackRequest;
import com.mktplace.model.PaymentCallbackResponse;
import com.mktplace.model.PaymentRequest;
import com.mktplace.model.PaymentResponse;
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
 * A delegate to be called by the {@link PaymentApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface PaymentApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /pay : API for payment
     *
     * @param paymentRequest  (required)
     * @return payment initiated (status code 200)
     *         or Internal server error (status code 500)
     * @see PaymentApi#pay
     */
    default Mono<ResponseEntity<PaymentResponse>> pay(Mono<PaymentRequest> paymentRequest,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"payment\" : { \"booking_id\" : 6, \"createdAt\" : 5, \"payment_id\" : 0, \"transaction_amount\" : 1.4658129805029452, \"status\" : \"initiated\", \"updatedAt\" : 5 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(paymentRequest).then(Mono.empty());

    }

    /**
     * POST /paycallback : API for payment callback
     *
     * @param paymentCallbackRequest  (required)
     * @return payment sttaus moved to success / failure (status code 200)
     *         or Internal server error (status code 500)
     * @see PaymentApi#paycallback
     */
    default Mono<ResponseEntity<PaymentCallbackResponse>> paycallback(Mono<PaymentCallbackRequest> paymentCallbackRequest,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"payment\" : { \"booking_id\" : 6, \"createdAt\" : 5, \"payment_id\" : 0, \"transaction_amount\" : 1.4658129805029452, \"status\" : \"initiated\", \"updatedAt\" : 5 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(paymentCallbackRequest).then(Mono.empty());

    }

}
