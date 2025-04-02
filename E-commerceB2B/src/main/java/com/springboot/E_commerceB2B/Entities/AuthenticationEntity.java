package com.springboot.E_commerceB2B.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationEntity {

    private String username;
    private String password;

    public AuthenticationEntity() {

    }

    public AuthenticationEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
