package com.sparta.limited.auth_service.presentation.external.controller;

import com.sparta.limited.auth_service.application.dto.request.AuthSignupRequest;
import com.sparta.limited.auth_service.application.dto.response.AuthSignupResponse;
import com.sparta.limited.auth_service.application.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthExternalController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthSignupResponse> signup(
        @RequestBody AuthSignupRequest request) {
        AuthSignupResponse response = authService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
