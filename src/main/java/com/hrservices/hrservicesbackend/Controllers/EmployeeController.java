package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.EmployeeDto;
import com.hrservices.hrservicesbackend.Services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping public List<EmployeeDto> all() { return service.getAll(); }
    @GetMapping("/{id}") public EmployeeDto one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public EmployeeDto create(@RequestBody EmployeeDto dto) { return service.create(dto); }
    @PutMapping("/{id}") public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}