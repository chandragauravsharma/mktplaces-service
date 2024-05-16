/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mktplace.api;

import com.mktplace.model.Item;
import com.mktplace.model.Transaction;
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
@Tag(name = "Default", description = "the Default API")
public interface DefaultApi {

    default DefaultApiDelegate getDelegate() {
        return new DefaultApiDelegate() {};
    }

    /**
     * GET /items : Get all items
     *
     * @return A list of items (status code 200)
     */
    @Operation(
        operationId = "itemsGet",
        summary = "Get all items",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of items", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Item.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/items",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<Item>>> itemsGet(
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().itemsGet(exchange);
    }


    /**
     * POST /items : Create a new item
     *
     * @param item  (required)
     * @return Item created successfully (status code 201)
     */
    @Operation(
        operationId = "itemsPost",
        summary = "Create a new item",
        responses = {
            @ApiResponse(responseCode = "201", description = "Item created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/items",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<Item>> itemsPost(
        @Parameter(name = "Item", description = "", required = true) @Valid @RequestBody Mono<Item> item,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().itemsPost(item, exchange);
    }


    /**
     * GET /transactions : Get all transactions
     *
     * @return A list of transactions (status code 200)
     */
    @Operation(
        operationId = "transactionsGet",
        summary = "Get all transactions",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of transactions", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/transactions",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<Transaction>>> transactionsGet(
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().transactionsGet(exchange);
    }


    /**
     * POST /transactions : Create a new transaction
     *
     * @param transaction  (required)
     * @return Transaction created successfully (status code 201)
     */
    @Operation(
        operationId = "transactionsPost",
        summary = "Create a new transaction",
        responses = {
            @ApiResponse(responseCode = "201", description = "Transaction created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/transactions",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<Transaction>> transactionsPost(
        @Parameter(name = "Transaction", description = "", required = true) @Valid @RequestBody Mono<Transaction> transaction,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        return getDelegate().transactionsPost(transaction, exchange);
    }

}
