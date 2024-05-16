package com.mktplace.api.impl;

import com.mktplace.api.ProductApiDelegate;
import com.mktplace.model.Product;
import com.mktplace.model.ProductCreationRequest;
import com.mktplace.model.ProductCreationResponse;
import com.mktplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProductApiDelegateImpl implements ProductApiDelegate {
    @Autowired
    ProductService productService;

    @Override
    public Mono<ResponseEntity<ProductCreationResponse>> createProduct(Mono<ProductCreationRequest> productCreationRequest, ServerWebExchange exchange) {
        return productService.createProduct(productCreationRequest)
                .map(productCreationResponse -> ResponseEntity.status(HttpStatus.OK).body(productCreationResponse))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public Mono<ResponseEntity<Flux<Product>>> getAllProducts(ServerWebExchange exchange) {
        return productService.getAllProducts()
                .collectList()
                .map(products -> ResponseEntity.status(HttpStatus.OK).body(Flux.fromIterable(products)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public Mono<ResponseEntity<Product>> getProductById(Long productId, ServerWebExchange exchange) {
        return productService.getProductById(productId)
                .map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
