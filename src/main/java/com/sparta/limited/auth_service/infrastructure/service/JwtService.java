package com.sparta.limited.auth_service.infrastructure.service;

import com.sparta.limited.auth_service.application.dto.response.AuthLoginResponse;
import com.sparta.limited.auth_service.application.info.UserInfo;
import com.sparta.limited.auth_service.infrastructure.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthLoginResponse createTokens(HttpServletResponse servletResponse,
        UserInfo userInfo) {
        String accessToken = jwtTokenProvider.crateAccessToken(userInfo.userId(),
            userInfo.username(), userInfo.role());

        String refreshToken = jwtTokenProvider.createRefreshToken(userInfo.userId());
        addRefreshTokenToCookie(servletResponse, refreshToken);

        return AuthLoginResponse.of(accessToken);
    }

    private void addRefreshTokenToCookie(HttpServletResponse servletResponse, String refreshToken) {
        ResponseCookie responseCookie = ResponseCookie.from("refreshToken", refreshToken)
            .httpOnly(true)
            .secure(true)
            .maxAge(Duration.ofDays(1))
            .path("/")
            .build();
        servletResponse.addHeader("Set-Cookie", responseCookie.toString());
    }
}
