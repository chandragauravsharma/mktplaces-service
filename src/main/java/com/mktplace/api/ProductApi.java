/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mktplace.api;

import com.mktplace.model.Product;
import com.mktplace.model.ProductCreationRequest;
import com.mktplace.model.ProductCreationResponse;
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
@Tag(name = "Product", description = "the Product API")
public interface ProductApi {

    default ProductApiDelegate getDelegate() {
        return new ProductApiDelegate() {};
    }

    /**
     * POST /products : Create a new product
     *
     * @param productCreationRequest  (required)
     * @return Product created successfully (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "createProduct",
        summary = "Create a new product",
        tags = { "Product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Product created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCreationResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/products",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<ProductCreationResponse>> createProduct(
        @Parameter(name = "ProductCreationRequest", description = "", required = true) @Valid @RequestBody Mono<ProductCreationRequest> productCreationRequest,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().createProduct(productCreationRequest, exchange);
    }


    /**
     * GET /products : Get all products
     *
     * @return A list of items (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "getAllProducts",
        summary = "Get all products",
        tags = { "Product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of items", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Product.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<Product>>> getAllProducts(
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().getAllProducts(exchange);
    }


    /**
     * GET /products/{productId} : Get a product by Id
     *
     * @param productId ID of the product to retrieve (required)
     * @return product details (status code 200)
     *         or Product not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "getProductById",
        summary = "Get a product by Id",
        tags = { "Product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "product details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products/{productId}",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Product>> getProductById(
        @Parameter(name = "productId", description = "ID of the product to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("productId") Long productId,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().getProductById(productId, exchange);
    }

}
