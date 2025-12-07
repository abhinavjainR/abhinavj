package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.PerformanceDto;
import com.hrservices.hrservicesbackend.Services.PerformanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {
    private final PerformanceService service;
    public PerformanceController(PerformanceService service) { this.service = service; }

    @GetMapping public List<PerformanceDto> all() { return service.getAll(); }
    @GetMapping("/{id}") public PerformanceDto one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public PerformanceDto create(@RequestBody PerformanceDto dto) { return service.create(dto); }
    @PutMapping("/{id}") public PerformanceDto update(@PathVariable Long id, @RequestBody PerformanceDto dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}