package com.KLA.Orbotech_CLI.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUser {
    private String email;
    private String password;

    public AuthUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
