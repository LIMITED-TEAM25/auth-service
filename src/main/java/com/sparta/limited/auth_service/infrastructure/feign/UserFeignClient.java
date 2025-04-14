package com.sparta.limited.auth_service.infrastructure.feign;

import com.sparta.limited.auth_service.infrastructure.dto.request.UserCreateInternalRequest;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserCreateInternalResponse;
import com.sparta.limited.auth_service.infrastructure.dto.response.UserSearchInternalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserFeignClient {

    @PostMapping("/api/v1/internal/users")
    UserCreateInternalResponse createUser(
        @RequestBody UserCreateInternalRequest request);

    @GetMapping("/api/v1/internal/users/search")
    UserSearchInternalResponse searchUserByUsername(
        @RequestParam(value = "username") String username);
}
