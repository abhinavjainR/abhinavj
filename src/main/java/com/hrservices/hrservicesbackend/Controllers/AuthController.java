package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.AuthDto;
import com.hrservices.hrservicesbackend.Services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) { this.service = service; }

    @PostMapping("/login")
    public AuthDto login(@RequestBody AuthDto dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public AuthDto register(@RequestBody AuthDto dto) {
        return service.register(dto);
    }
}