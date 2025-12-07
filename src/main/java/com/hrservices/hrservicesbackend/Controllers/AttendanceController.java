package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.AttendanceDto;
import com.hrservices.hrservicesbackend.Repositories.AttendanceRepository;
import com.hrservices.hrservicesbackend.Services.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    public AttendanceRepository repo;
    private final AttendanceService service;
    public AttendanceController(AttendanceService service) { this.service = service; }

    @GetMapping public List<AttendanceDto> all() { return service.getAll(); }
    @GetMapping("/{id}") public AttendanceDto one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public AttendanceDto create(@RequestBody AttendanceDto dto) { return service.create(dto); }
    @PutMapping("/{id}") public AttendanceDto update(@PathVariable Long id, @RequestBody AttendanceDto dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}