package com.sparta.limited.auth_service.infrastructure.dto.response;

import lombok.Getter;

@Getter
public class UserSearchInternalResponse {

    private final Long userId;
    private final String username;
    private final String password;
    private final String role;
    private final String gender;
    private final Integer age;
    private final String address;

    private UserSearchInternalResponse(
        Long userId,
        String username,
        String password,
        String role,
        String gender,
        Integer age,
        String address
    ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public static UserSearchInternalResponse of(
        Long userId,
        String username,
        String password,
        String role,
        String gender,
        Integer age,
        String address
    ) {
        return new UserSearchInternalResponse(
            userId,
            username,
            password,
            role,
            gender,
            age,
            address
        );
    }
}
