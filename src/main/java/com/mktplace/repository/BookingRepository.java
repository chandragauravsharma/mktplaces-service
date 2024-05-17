package com.mktplace.repository;

import com.mktplace.model.dto.BookingDTO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookingRepository extends R2dbcRepository<BookingDTO, Long> {
    @Modifying
    @Query("UPDATE booking SET status = :status WHERE booking_id = :bookingId")
    Mono<Integer> updateBookingStatus(@Param("bookingId") Long bookingId,
                                      @Param("status") BookingDTO.StatusEnum status);
}


