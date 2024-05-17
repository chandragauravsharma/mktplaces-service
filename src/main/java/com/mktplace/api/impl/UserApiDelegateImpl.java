package com.mktplace.api.impl;

import com.mktplace.api.UserApiDelegate;
import com.mktplace.model.Product;
import com.mktplace.model.User;
import com.mktplace.model.UserCreationRequest;
import com.mktplace.model.UserCreationResponse;
import com.mktplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserApiDelegateImpl implements UserApiDelegate {
    @Autowired
    private UserService userService;

    @Override
    public Mono<ResponseEntity<User>> getUserById(Long userId, ServerWebExchange exchange) {
        return userService.getUserById(userId)
                .map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public Mono<ResponseEntity<UserCreationResponse>> createUser(Mono<UserCreationRequest> userCreationRequest, ServerWebExchange exchange) {
        return userService.createUser(userCreationRequest)
                .map(userCreationResponse -> ResponseEntity.status(HttpStatus.OK).body(userCreationResponse))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public Mono<ResponseEntity<Flux<Product>>> getAllProductsListedByUser(Long userId, ServerWebExchange exchange) {
        return userService.getAllProductsListedByUser(userId)
                .collectList()
                .map(products -> ResponseEntity.status(HttpStatus.OK).body(Flux.fromIterable(products)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
