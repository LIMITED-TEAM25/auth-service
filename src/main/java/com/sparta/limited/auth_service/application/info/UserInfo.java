package com.sparta.limited.auth_service.application.info;

public record UserInfo(
    Long userId,
    String username,
    String password,
    String role,
    String gender,
    Integer age,
    String address
) {

    public static UserInfo from(
        Long userId,
        String username,
        String password,
        String role,
        String gender,
        Integer age,
        String address
    ) {
        return new UserInfo(
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
