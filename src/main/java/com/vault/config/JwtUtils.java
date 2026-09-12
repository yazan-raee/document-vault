package com.vault.config;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

private static final String SECRET_STRING = "your-very-secure-secret-key-that-is-at-least-32-bytes!";
private final SecretKey key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
private final long expirationTime = 3600000; // 1 hour in milliseconds

    public String generateToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date(currentTimeMillis))
            .expiration(new Date(currentTimeMillis + expirationTime)) // 1 hour expiration
            .signWith(key)
            .compact();

    }

    public String extractUsernameFromToken(String token) {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        try {
            String extractedUsername = extractUsernameFromToken(token);
            return extractedUsername.equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}
