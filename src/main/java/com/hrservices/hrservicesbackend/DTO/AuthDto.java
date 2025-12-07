package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String confirmPassword; // if UI has confirm field
    private String token;

    public AuthDto() {}

// getters & setters
}