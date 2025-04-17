package com.sparta.limited.auth_service.presentation.external.controller;

import com.sparta.limited.auth_service.application.dto.request.AuthLoginRequest;
import com.sparta.limited.auth_service.application.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.application.dto.response.AuthLoginResponse;
import com.sparta.limited.auth_service.application.dto.response.AuthSignupResponse;
import com.sparta.limited.auth_service.application.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthSignupResponse> signup(
        @RequestBody AuthSignupRequest request
    ) {
        AuthSignupResponse response = authService.signup(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/v1/users/my-page")
            .build()
            .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(
        @RequestBody AuthLoginRequest request,
        HttpServletResponse servletResponse
    ) {
        AuthLoginResponse response = authService.login(servletResponse, request);
        return ResponseEntity.ok(response);
    }

}