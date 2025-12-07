package com.hrservices.hrservicesbackend.Services;

import com.hrservices.hrservicesbackend.DTO.AuthDto;
import com.hrservices.hrservicesbackend.DTO.Role;
import com.hrservices.hrservicesbackend.Entity.User;
import com.hrservices.hrservicesbackend.Repositories.UserRepository;
import com.hrservices.hrservicesbackend.Security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public AuthService(AuthenticationManager authManager, JwtUtil jwtUtil, UserRepository userRepo, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public AuthDto login(AuthDto dto) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );
        String token = jwtUtil.generateToken(auth);
        dto.setToken(token);
        return dto;
    }

    public AuthDto register(AuthDto dto) {
        if (userRepo.existsByEmail(dto.getEmail())) throw new IllegalArgumentException("Email already exists");
        User u = new User();
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setRole(Role.USER);
        User saved = userRepo.save(u);
        dto.setId(saved.getId());
        return dto;
    }
}