package com.springboot.E_commerceB2B.Service;

import com.springboot.E_commerceB2B.Entities.RefreshTokens;
import com.springboot.E_commerceB2B.Repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class RefreshTokenService {

    @Value("${jwt.refresh.expiration}")
    private Long refreshTokenExpiration;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    // Criar o refresh token
    public RefreshTokens createRefreshToken(String username) {
        RefreshTokens refreshToken = new RefreshTokens();
        refreshToken.setUsername(username);
        refreshToken.setToken(java.util.UUID.randomUUID().toString());
        refreshToken.setExpirationDate(String.valueOf(LocalDateTime.now().plus(refreshTokenExpiration, ChronoUnit.MILLIS)));
        return refreshTokenRepository.save(refreshToken);
    }

    //Verificar a expiração do token
    public RefreshTokens verifyExpiration(RefreshTokens refreshToken) {
        if (refreshToken.getExpirationDate() == null || LocalDateTime.now().isAfter(LocalDateTime.parse(refreshToken.getExpirationDate()))) {
            refreshTokenRepository.delete(refreshToken);
            return null;
        }
        return refreshToken;
    }

    public RefreshTokens findByToken(String token) {
        return refreshTokenRepository.findByToken(token).orElse(null);
    }

    public void deleteByToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}