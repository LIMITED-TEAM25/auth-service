package com.sparta.limited.auth_service.presentation.dto.request;

import lombok.Getter;

@Getter
public class AuthSignupRequest {

    private String username;
    private String password;
    private String gender;
    private Integer age;
    private String address;

}
