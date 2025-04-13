package com.sparta.limited.auth_service.presentation.dto.response;

import lombok.Getter;

@Getter
public class AuthSignupResponse {

    private final Long userId;
    private final String username;
    private final String gender;
    private final Integer age;
    private final String address;

    private AuthSignupResponse(
        Long userId,
        String username,
        String gender,
        Integer age,
        String address
    ) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public static AuthSignupResponse of(Long userId,
        String username,
        String gender,
        Integer age,
        String address
    ) {
        return new AuthSignupResponse(
            userId,
            username,
            gender,
            age,
            address
        );
    }

}
