package com.sparta.limited.auth_service.application.dto.request;

import lombok.Getter;

@Getter
public class AuthLoginRequest {

    private String username;
    private String password;

}
