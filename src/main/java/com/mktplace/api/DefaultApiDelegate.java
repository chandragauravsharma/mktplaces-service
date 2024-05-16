package com.mktplace.api;

import com.mktplace.model.Item;
import com.mktplace.model.Transaction;
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
 * A delegate to be called by the {@link DefaultApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface DefaultApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /items : Get all items
     *
     * @return A list of items (status code 200)
     * @see DefaultApi#itemsGet
     */
    default Mono<ResponseEntity<Flux<Item>>> itemsGet(ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"createdAt\" : 5, \"quantity\" : 1, \"sellerId\" : 5, \"price\" : 6.027456183070403, \"name\" : \"name\", \"id\" : 0, \"updatedAt\" : 2 }, { \"createdAt\" : 5, \"quantity\" : 1, \"sellerId\" : 5, \"price\" : 6.027456183070403, \"name\" : \"name\", \"id\" : 0, \"updatedAt\" : 2 } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * POST /items : Create a new item
     *
     * @param item  (required)
     * @return Item created successfully (status code 201)
     * @see DefaultApi#itemsPost
     */
    default Mono<ResponseEntity<Item>> itemsPost(Mono<Item> item,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : 5, \"quantity\" : 1, \"sellerId\" : 5, \"price\" : 6.027456183070403, \"name\" : \"name\", \"id\" : 0, \"updatedAt\" : 2 }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(item).then(Mono.empty());

    }

    /**
     * GET /transactions : Get all transactions
     *
     * @return A list of transactions (status code 200)
     * @see DefaultApi#transactionsGet
     */
    default Mono<ResponseEntity<Flux<Transaction>>> transactionsGet(ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"itemId\" : 1, \"price\" : 5.962133916683182, \"id\" : 0, \"buyerId\" : 6, \"transactionDate\" : 5 }, { \"itemId\" : 1, \"price\" : 5.962133916683182, \"id\" : 0, \"buyerId\" : 6, \"transactionDate\" : 5 } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * POST /transactions : Create a new transaction
     *
     * @param transaction  (required)
     * @return Transaction created successfully (status code 201)
     * @see DefaultApi#transactionsPost
     */
    default Mono<ResponseEntity<Transaction>> transactionsPost(Mono<Transaction> transaction,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"itemId\" : 1, \"price\" : 5.962133916683182, \"id\" : 0, \"buyerId\" : 6, \"transactionDate\" : 5 }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(transaction).then(Mono.empty());

    }

}
