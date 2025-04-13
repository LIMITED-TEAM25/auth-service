package com.sparta.limited.auth_service.application.mapper;

import com.sparta.limited.auth_service.application.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.application.dto.response.AuthSignupResponse;
import com.sparta.limited.auth_service.infrastructure.dto.request.UserCreateInternalRequest;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserCreateInternalResponse;

public class AuthDtoMapper {

    public static UserCreateInternalRequest toCreateUserInternalDto(AuthSignupRequest request,
        String password) {
        return UserCreateInternalRequest.of(
            request.getUsername(),
            password,
            request.getGender(),
            request.getAge(),
            request.getAddress()
        );
    }

    public static AuthSignupResponse toSignupExternalResponse(UserCreateInternalResponse response) {
        return AuthSignupResponse.of(
            response.getUserId(),
            response.getUsername(),
            response.getGender(),
            response.getAge(),
            response.getAddress()
        );
    }

}
