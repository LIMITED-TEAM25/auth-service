package com.sparta.limited.auth_service.infrastructure.dto.request;

import lombok.Getter;

@Getter
public class UserCreateInternalRequest {

    private final String username;
    private final String password;
    private final String gender;
    private final Integer age;
    private final String address;

    private UserCreateInternalRequest(
        String username,
        String password,
        String gender,
        Integer age,
        String address
    ) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public static UserCreateInternalRequest of(
        String username,
        String password,
        String gender,
        Integer age,
        String address
    ) {
        return new UserCreateInternalRequest(
            username,
            password,
            gender,
            age,
            address
        );
    }


}
