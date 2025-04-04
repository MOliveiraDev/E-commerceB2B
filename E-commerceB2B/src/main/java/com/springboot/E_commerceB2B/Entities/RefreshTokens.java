package com.springboot.E_commerceB2B.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RefreshTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UUID;

    private String token;
    private String username;
    private String expirationDate;

    public RefreshTokens() {
    }

    public RefreshTokens(String token, String username, String expirationDate) {
        this.token = token;
        this.username = username;
        this.expirationDate = expirationDate;
    }
}
