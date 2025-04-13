package com.sparta.limited.auth_service.application.service.user;

import com.sparta.limited.auth_service.infrastructure.dto.request.UserCreateInternalRequest;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserCreateInternalResponse;
import com.sparta.limited.auth_service.infrastructure.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFeignService {

    private final UserFeignClient userFeignClient;

    public UserCreateInternalResponse createUser(UserCreateInternalRequest request) {
        return userFeignClient.createUser(request);
    }

}
