package com.springboot.E_commerceB2B.Entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AuthenticationResponse {
    private String jwt;
    private String refreshToken;
    private String email;

    public AuthenticationResponse(String jwt, String refreshToken, String email) {
        this.jwt = jwt;
        this.refreshToken = refreshToken;
        this.email = email;
    }

}