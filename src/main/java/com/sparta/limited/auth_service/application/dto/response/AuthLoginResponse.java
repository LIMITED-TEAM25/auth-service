package com.sparta.limited.auth_service.application.dto.response;

import lombok.Getter;

@Getter
public class AuthLoginResponse {

    private final String accessToken;

    private AuthLoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public static AuthLoginResponse of(String accessToken) {
        return new AuthLoginResponse(accessToken);
    }

}
