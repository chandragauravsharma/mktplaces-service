package com.mktplace.api;

import com.mktplace.model.Booking;
import com.mktplace.model.Product;
import com.mktplace.model.User;
import com.mktplace.model.UserCreationRequest;
import com.mktplace.model.UserCreationResponse;
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
 * A delegate to be called by the {@link UserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface UserApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /users : Create a new user
     *
     * @param userCreationRequest  (required)
     * @return User created successfully (status code 200)
     *         or Internal server error (status code 500)
     * @see UserApi#createUser
     */
    default Mono<ResponseEntity<UserCreationResponse>> createUser(Mono<UserCreationRequest> userCreationRequest,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"user\" : { \"createdAt\" : 6, \"password\" : \"password\", \"last_purchase_timestamp\" : 5, \"user_id\" : 0, \"email\" : \"email\", \"username\" : \"username\", \"updatedAt\" : 1 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(userCreationRequest).then(Mono.empty());

    }

    /**
     * GET /users/{userId}/bookings : Get all bookings done by a user / all products bought by a user
     *
     * @param userId ID of the user to retrieve bookings for (required)
     * @return Booking details (status code 200)
     *         or Internal server error (status code 500)
     * @see UserApi#getAllBookingsByUser
     */
    default Mono<ResponseEntity<Flux<Booking>>> getAllBookingsByUser(Long userId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"booking_id\" : 0, \"createdAt\" : 7, \"payment_id\" : 2, \"product_id\" : 5, \"transaction_amount\" : 5.637376656633329, \"buyer_id\" : 6, \"seller_id\" : 1, \"status\" : \"created\", \"updatedAt\" : 9 }, { \"booking_id\" : 0, \"createdAt\" : 7, \"payment_id\" : 2, \"product_id\" : 5, \"transaction_amount\" : 5.637376656633329, \"buyer_id\" : 6, \"seller_id\" : 1, \"status\" : \"created\", \"updatedAt\" : 9 } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /users/{userId}/products : Get all products listed by a user
     *
     * @param userId ID of the user to retrieve product listings for (required)
     * @return Product details (status code 200)
     *         or Internal server error (status code 500)
     * @see UserApi#getAllProductsListedByUser
     */
    default Mono<ResponseEntity<Flux<Product>>> getAllProductsListedByUser(Long userId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"quantity_sold\" : 5, \"createdAt\" : 7, \"user_id\" : 6, \"product_id\" : 0, \"name\" : \"name\", \"base_price\" : 1.4658129805029452, \"description\" : \"description\", \"quantity_on_hold\" : 2, \"quantity_available\" : 5, \"updatedAt\" : 9 }, { \"quantity_sold\" : 5, \"createdAt\" : 7, \"user_id\" : 6, \"product_id\" : 0, \"name\" : \"name\", \"base_price\" : 1.4658129805029452, \"description\" : \"description\", \"quantity_on_hold\" : 2, \"quantity_available\" : 5, \"updatedAt\" : 9 } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /users/{userId} : Get user details by Id
     *
     * @param userId ID of the user to retrieve (required)
     * @return User details (status code 200)
     *         or User not found (status code 404)
     *         or Internal server error (status code 500)
     * @see UserApi#getUserById
     */
    default Mono<ResponseEntity<User>> getUserById(Long userId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : 6, \"password\" : \"password\", \"last_purchase_timestamp\" : 5, \"user_id\" : 0, \"email\" : \"email\", \"username\" : \"username\", \"updatedAt\" : 1 }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

}
