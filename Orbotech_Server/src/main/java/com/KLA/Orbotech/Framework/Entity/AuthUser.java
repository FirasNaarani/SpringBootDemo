package com.KLA.Orbotech.Framework.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthUser {
    private String email;

    private String password;

    public AuthUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
