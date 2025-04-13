package com.sparta.limited.auth_service.infrastructure.dto.request;

import lombok.Getter;

@Getter
public class UserSearchInternalRequest {

    private String username;
    private String password;

}
