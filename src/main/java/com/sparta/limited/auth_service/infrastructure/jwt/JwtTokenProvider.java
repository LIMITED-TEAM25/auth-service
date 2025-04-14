package com.sparta.limited.auth_service.infrastructure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private final JwtProperties jwtProperties;

    private Key key;

    @PostConstruct
    public void ketInit() {
        key = Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
    }

    public String crateAccessToken(Long userId, String username, String role) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtProperties.getAccessExp());

        return Jwts.builder()
            .setSubject(String.valueOf(userId))
            .claim("username", username)
            .claim("role", role)
            .setIssuedAt(now)
            .setExpiration(expirationDate)
            .signWith(key, signatureAlgorithm)
            .compact();
    }

    public String createRefreshToken(Long userId) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtProperties.getRefreshExp());

        return Jwts.builder()
            .setSubject(String.valueOf(userId))
            .setIssuedAt(now)
            .setExpiration(expirationDate)
            .signWith(key, signatureAlgorithm)
            .compact();
    }

}
