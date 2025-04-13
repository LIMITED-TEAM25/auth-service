package com.sparta.limited.auth_service.infrastructure.feign;

import com.sparta.limited.auth_service.infrastructure.dto.request.UserCreateInternalRequest;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserCreateInternalResponse;
import com.sparta.limited.auth_service.presentation.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.presentation.dto.response.AuthSignupResponse;

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
