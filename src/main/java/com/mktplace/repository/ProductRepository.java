package com.mktplace.repository;

import com.mktplace.model.dto.ProductDTO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends R2dbcRepository<ProductDTO, Long> {
    Flux<ProductDTO> findByUserId(Long userId);

    @Modifying
    @Query("UPDATE products SET quantity_available = quantity_available - 1, quantity_on_hold = quantity_on_hold + 1 " +
            "WHERE product_id = :productId AND user_id = :userId")
    Mono<Integer> updateProductQuantitiesForHold(@Param("productId") Long productId, @Param("userId") Long userId);

    @Modifying
    @Query("UPDATE products SET quantity_on_hold = quantity_on_hold - 1, quantity_sold = quantity_sold + 1 " +
            "WHERE product_id = :productId AND user_id = :userId")
    Mono<Integer> updateProductQuantitiesForSoldOut(@Param("productId") Long productId, @Param("userId") Long userId);
}


