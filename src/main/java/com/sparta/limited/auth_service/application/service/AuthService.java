package com.sparta.limited.auth_service.application.service;

import com.sparta.limited.auth_service.application.dto.request.AuthLoginRequest;
import com.sparta.limited.auth_service.application.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.application.dto.response.AuthLoginResponse;
import com.sparta.limited.auth_service.application.dto.response.AuthSignupResponse;
import com.sparta.limited.auth_service.application.info.UserInfo;
import com.sparta.limited.auth_service.infrastructure.password.PasswordEncoderUtil;
import com.sparta.limited.auth_service.infrastructure.service.JwtService;
import com.sparta.limited.auth_service.infrastructure.service.UserFeignService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserFeignService userFeignService;
    private final JwtService jwtService;

    public AuthSignupResponse signup(AuthSignupRequest request) {
        String password = PasswordEncoderUtil.encode(request.getPassword());
        return userFeignService.createUser(request, password);
    }

    public AuthLoginResponse login(HttpServletResponse servletResponse, AuthLoginRequest request) {
        UserInfo userInfo = userFeignService.searchUserByUsername(request);

        if (!PasswordEncoderUtil.isMatched(request.getPassword(), userInfo.password())) {
            throw new RuntimeException("사용자 비밀번호가 일치하지 않습니다");
        }

        return jwtService.createTokens(servletResponse, userInfo);
    }

}
