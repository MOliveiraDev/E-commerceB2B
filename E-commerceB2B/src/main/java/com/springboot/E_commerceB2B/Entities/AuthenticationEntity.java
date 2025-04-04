package com.springboot.E_commerceB2B.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationEntity {

    private String username;
    private String email;
    private String password;

    public AuthenticationEntity() {

    }

    public AuthenticationEntity(String username, String password, String email) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
