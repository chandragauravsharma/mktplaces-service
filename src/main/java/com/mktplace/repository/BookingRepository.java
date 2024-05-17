package com.mktplace.repository;

import com.mktplace.model.Booking;
import com.mktplace.model.dto.BookingDTO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface BookingRepository extends R2dbcRepository<BookingDTO, Long> {
    @Modifying
    @Query("UPDATE booking SET status = :status WHERE booking_id = :bookingId")
    Mono<Integer> updateBookingStatus(@Param("bookingId") Long bookingId,
                                      @Param("status") BookingDTO.StatusEnum status);

    @Query("SELECT COUNT(*) FROM booking WHERE user_id = :userId AND created_at >= :lastMonth")
    Mono<Integer> findBookingsByBuyerIdInLastMonth(@Param("userId") Long userId, @Param("lastMonth") LocalDateTime lastMonth);
}


