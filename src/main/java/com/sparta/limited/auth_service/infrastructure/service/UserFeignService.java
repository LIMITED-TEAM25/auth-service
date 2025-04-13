package com.sparta.limited.auth_service.infrastructure.service;

import com.sparta.limited.auth_service.application.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.application.dto.response.AuthSignupResponse;
import com.sparta.limited.auth_service.application.mapper.AuthDtoMapper;
import com.sparta.limited.auth_service.infrastructure.dto.request.UserCreateInternalRequest;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserCreateInternalResponse;
import com.sparta.limited.auth_service.infrastructure.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFeignService {

    private final UserFeignClient userFeignClient;

    public AuthSignupResponse createUser(AuthSignupRequest request, String password) {
        UserCreateInternalRequest userCreateRequest = AuthDtoMapper.toCreateUserInternalDto(request,
            password);
        UserCreateInternalResponse userCreateResponse = userFeignClient.createUser(
            userCreateRequest);
        return AuthDtoMapper.toSignupExternalResponse(userCreateResponse);
    }

}
