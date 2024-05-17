package com.mktplace.repository;

import com.mktplace.model.dto.UserDTO;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends R2dbcRepository<UserDTO, Long> {
}


