package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.TaskDto;
import com.hrservices.hrservicesbackend.Services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }

    @GetMapping public List<TaskDto> all() { return service.getAll(); }
    @GetMapping("/{id}") public TaskDto one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public TaskDto create(@RequestBody TaskDto dto) { return service.create(dto); }
    @PutMapping("/{id}") public TaskDto update(@PathVariable Long id, @RequestBody TaskDto dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}