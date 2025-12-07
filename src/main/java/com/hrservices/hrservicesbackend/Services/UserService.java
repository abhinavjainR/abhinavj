package com.hrservices.hrservicesbackend.Services;
// com.example.hr.user.UserService.java

import com.hrservices.hrservicesbackend.DTO.UserDto;
import com.hrservices.hrservicesbackend.Entity.User;
import com.hrservices.hrservicesbackend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) { this.repo = repo; }

    public List<UserDto> list() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public UserDto get(Long id) {
        User u = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return toDTO(u);
    }

    private UserDto toDTO(User u) {
        UserDto dto = new UserDto();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setEmail(u.getEmail());
        dto.setRole(u.getRole().name());
        dto.setPhone(u.getPhone());
        dto.setAddress(u.getAddress());
        return dto;
    }
}