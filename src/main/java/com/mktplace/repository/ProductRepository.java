package com.mktplace.repository;

import com.mktplace.model.dto.ProductDTO;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends R2dbcRepository<ProductDTO, Integer> {
    Flux<ProductDTO> findByUserId(Long userId);
}


