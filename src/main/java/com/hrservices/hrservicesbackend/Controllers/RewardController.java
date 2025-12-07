package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.RewardDto;
import com.hrservices.hrservicesbackend.Services.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
    private final RewardService service;
    public RewardController(RewardService service) { this.service = service; }

    @GetMapping public List<RewardDto> all() { return service.getAll(); }
    @GetMapping("/{id}") public RewardDto one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public RewardDto create(@RequestBody RewardDto dto) { return service.create(dto); }
    @PutMapping("/{id}") public RewardDto update(@PathVariable Long id, @RequestBody RewardDto dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}