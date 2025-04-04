package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.RefreshTokens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokens, Long> {
    Optional<RefreshTokens> findByToken(String token);
    void deleteByToken(String token);
}
