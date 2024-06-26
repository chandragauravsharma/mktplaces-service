/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mktplace.api;

import com.mktplace.model.PaymentCallbackRequest;
import com.mktplace.model.PaymentCallbackResponse;
import com.mktplace.model.PaymentRequest;
import com.mktplace.model.PaymentResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "Payment", description = "the Payment API")
public interface PaymentApi {

    default PaymentApiDelegate getDelegate() {
        return new PaymentApiDelegate() {};
    }

    /**
     * POST /pay : API for payment
     *
     * @param paymentRequest  (required)
     * @return payment initiated (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "pay",
        summary = "API for payment",
        tags = { "Payment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "payment initiated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pay",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<PaymentResponse>> pay(
        @Parameter(name = "PaymentRequest", description = "", required = true) @Valid @RequestBody Mono<PaymentRequest> paymentRequest,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().pay(paymentRequest, exchange);
    }


    /**
     * POST /paycallback : API for payment callback
     *
     * @param paymentCallbackRequest  (required)
     * @return payment sttaus moved to success / failure (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "paycallback",
        summary = "API for payment callback",
        tags = { "Payment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "payment sttaus moved to success / failure", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentCallbackResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/paycallback",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<PaymentCallbackResponse>> paycallback(
        @Parameter(name = "PaymentCallbackRequest", description = "", required = true) @Valid @RequestBody Mono<PaymentCallbackRequest> paymentCallbackRequest,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().paycallback(paymentCallbackRequest, exchange);
    }

}
