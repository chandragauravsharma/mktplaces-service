package com.mktplace.api;

import com.mktplace.model.Product;
import com.mktplace.model.ProductCreationRequest;
import com.mktplace.model.ProductCreationResponse;
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
 * A delegate to be called by the {@link ProductApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface ProductApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products : Create a new product
     *
     * @param productCreationRequest  (required)
     * @return Product created successfully (status code 200)
     *         or Internal server error (status code 500)
     * @see ProductApi#createProduct
     */
    default Mono<ResponseEntity<ProductCreationResponse>> createProduct(Mono<ProductCreationRequest> productCreationRequest,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"product\" : { \"quantity_sold\" : 5, \"createdAt\" : 7, \"user_id\" : 6, \"product_id\" : 0, \"name\" : \"name\", \"base_price\" : 1.4658129805029452, \"description\" : \"description\", \"quantity_on_hold\" : 2, \"quantity_available\" : 5, \"updatedAt\" : 9 }, \"status\" : \"success\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(productCreationRequest).then(Mono.empty());

    }

    /**
     * GET /products : Get all products
     *
     * @return A list of items (status code 200)
     *         or Internal server error (status code 500)
     * @see ProductApi#getAllProducts
     */
    default Mono<ResponseEntity<Flux<Product>>> getAllProducts(ServerWebExchange exchange) {
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
     * GET /products/{productId} : Get a product by Id
     *
     * @param productId ID of the product to retrieve (required)
     * @return product details (status code 200)
     *         or Product not found (status code 404)
     *         or Internal server error (status code 500)
     * @see ProductApi#getProductById
     */
    default Mono<ResponseEntity<Product>> getProductById(Long productId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"quantity_sold\" : 5, \"createdAt\" : 7, \"user_id\" : 6, \"product_id\" : 0, \"name\" : \"name\", \"base_price\" : 1.4658129805029452, \"description\" : \"description\", \"quantity_on_hold\" : 2, \"quantity_available\" : 5, \"updatedAt\" : 9 }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

}
