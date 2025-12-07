package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.UserDto;
import com.hrservices.hrservicesbackend.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<UserDto> list() { return service.list(); }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) { return service.get(id); }
}