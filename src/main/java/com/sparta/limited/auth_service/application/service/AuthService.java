package com.sparta.limited.auth_service.application.service;

import com.sparta.limited.auth_service.infrastructure.dto.request.UserCreateInternalRequest;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserCreateInternalResponse;
import com.sparta.limited.auth_service.infrastructure.feign.AuthDtoMapper;
import com.sparta.limited.auth_service.infrastructure.feign.UserFeignClient;
import com.sparta.limited.auth_service.infrastructure.password.PasswordEncoderUtil;
import com.sparta.limited.auth_service.presentation.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.presentation.dto.response.AuthSignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserFeignClient userFeignClient;

    public AuthSignupResponse signup(AuthSignupRequest request) {
        String password = PasswordEncoderUtil.encode(request.getPassword());
        UserCreateInternalRequest createUserRequest = AuthDtoMapper.toCreateUserInternalDto(
            request,
            password);
        UserCreateInternalResponse response = userFeignClient.createUser(createUserRequest);
        return AuthDtoMapper.toSignupExternalResponse(response);
    }

}
