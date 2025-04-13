package com.sparta.limited.auth_service.application.service;

import com.sparta.limited.auth_service.application.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.application.dto.response.AuthSignupResponse;
import com.sparta.limited.auth_service.infrastructure.password.PasswordEncoderUtil;
import com.sparta.limited.auth_service.infrastructure.service.UserFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserFeignService userFeignService;

    public AuthSignupResponse signup(AuthSignupRequest request) {
        String password = PasswordEncoderUtil.encode(request.getPassword());
        return userFeignService.createUser(request, password);
    }

}
