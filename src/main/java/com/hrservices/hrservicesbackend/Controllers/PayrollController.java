package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.PayrollDto;
import com.hrservices.hrservicesbackend.Services.PayrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {
    private final PayrollService service;
    public PayrollController(PayrollService service) { this.service = service; }

    @GetMapping public List<PayrollDto> all() { return service.getAll(); }
    @GetMapping("/{id}") public PayrollDto one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public PayrollDto create(@RequestBody PayrollDto dto) { return service.create(dto); }
    @PutMapping("/{id}") public PayrollDto update(@PathVariable Long id, @RequestBody PayrollDto dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}