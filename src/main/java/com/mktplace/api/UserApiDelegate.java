package com.mktplace.api;

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
                String exampleString = "{ \"user\" : { \"createdAt\" : 0, \"password\" : \"password\", \"id\" : \"\", \"email\" : \"email\", \"username\" : \"username\", \"updatedAt\" : 6 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(userCreationRequest).then(Mono.empty());

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
    default Mono<ResponseEntity<User>> getUserById(String userId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : 0, \"password\" : \"password\", \"id\" : \"\", \"email\" : \"email\", \"username\" : \"username\", \"updatedAt\" : 6 }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

}
