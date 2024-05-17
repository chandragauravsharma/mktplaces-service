/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mktplace.api;

import com.mktplace.model.Booking;
import com.mktplace.model.BookingRequest;
import com.mktplace.model.BookingResponse;
import com.mktplace.model.CheckoutRequest;
import com.mktplace.model.CheckoutResponse;
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
@Tag(name = "Booking", description = "the Booking API")
public interface BookingApi {

    default BookingApiDelegate getDelegate() {
        return new BookingApiDelegate() {};
    }

    /**
     * POST /book : Update booking to BOOKED state, put hold on product and wait for payment to be done
     *
     * @param bookingRequest  (required)
     * @return checkout done and booking id generated (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "book",
        summary = "Update booking to BOOKED state, put hold on product and wait for payment to be done",
        tags = { "Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "checkout done and booking id generated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookingResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/book",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<BookingResponse>> book(
        @Parameter(name = "BookingRequest", description = "", required = true) @Valid @RequestBody Mono<BookingRequest> bookingRequest,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().book(bookingRequest, exchange);
    }


    /**
     * POST /checkout : Create a new booking with a unique id in CREATED state
     *
     * @param checkoutRequest  (required)
     * @return checkout done and booking id generated (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "checkout",
        summary = "Create a new booking with a unique id in CREATED state",
        tags = { "Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "checkout done and booking id generated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CheckoutResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/checkout",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<CheckoutResponse>> checkout(
        @Parameter(name = "CheckoutRequest", description = "", required = true) @Valid @RequestBody Mono<CheckoutRequest> checkoutRequest,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().checkout(checkoutRequest, exchange);
    }


    /**
     * GET /book/{bookingId} : Get a booking by Id
     *
     * @param bookingId ID of the booking to retrieve (required)
     * @return booking details (status code 200)
     *         or Booking not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "getBookingById",
        summary = "Get a booking by Id",
        tags = { "Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "booking details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))
            }),
            @ApiResponse(responseCode = "404", description = "Booking not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/book/{bookingId}",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Booking>> getBookingById(
        @Parameter(name = "bookingId", description = "ID of the booking to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("bookingId") Long bookingId,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().getBookingById(bookingId, exchange);
    }

}
