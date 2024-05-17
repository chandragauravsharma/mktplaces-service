package com.mktplace.repository;

import com.mktplace.model.dto.UserDTO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends R2dbcRepository<UserDTO, Long> {
    @Modifying
    @Query("UPDATE users SET last_purchase_timestamp = :lastPurchaseTimestamp " +
            "WHERE user_id = :userId")
    Mono<Integer> updateUserLastPurchaseTime(@Param("lastPurchaseTimestamp") LocalDateTime lastPurchaseTimestamp, @Param("userId") Long userId);
}


