package com.mktplace.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mktplace.model.User;
import com.mktplace.model.UserCreationRequest;
import com.mktplace.model.UserCreationResponse;
import com.mktplace.model.dto.UserDTO;
import com.mktplace.repository.UserRepository;
import com.mktplace.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserService(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    public Mono<UserCreationResponse> createUser(Mono<UserCreationRequest> userCreationRequest) {
        return userCreationRequest.flatMap(request -> {
            UserDTO user = new UserDTO();
            user.setId(CommonUtil.generateNewUserId());
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());

            return userRepository.save(user)
                    .map(savedUser -> {
                        UserCreationResponse response = new UserCreationResponse();
                        response.setStatus(UserCreationResponse.StatusEnum.SUCCESS);
                        response.setUser(objectMapper.convertValue(savedUser, User.class));
                        return response;
                    });
        });
    }

    public Mono<User> getUserById(String userId) {
        return userRepository.findById(userId)
                .map(r -> {
                    User user = new User();
                    user.setId(r.getId());
                    user.setUsername(r.getUsername());
                    user.setEmail(r.getEmail());
                    return user;
                });
    }
}