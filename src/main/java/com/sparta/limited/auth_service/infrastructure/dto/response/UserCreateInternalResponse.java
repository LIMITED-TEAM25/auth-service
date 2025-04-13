package com.sparta.limited.auth_service.infrastructure.dto.response;

import lombok.Getter;

@Getter
public class UserCreateInternalResponse {

    private final Long userId;
    private final String username;
    private final String role;
    private final String gender;
    private final Integer age;
    private final String address;

    private UserCreateInternalResponse(Long userId, String username, String role, String gender,
        Integer age, String address) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public static UserCreateInternalResponse of(Long userId, String username, String role,
        String gender,
        Integer age, String address) {
        return new UserCreateInternalResponse(
            userId,
            username,
            role,
            gender,
            age,
            address
        );
    }

}
