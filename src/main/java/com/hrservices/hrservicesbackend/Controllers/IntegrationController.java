package com.hrservices.hrservicesbackend.Controllers;

import com.hrservices.hrservicesbackend.DTO.IntegrationDto;
import com.hrservices.hrservicesbackend.Services.IntegrationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/integrations")
@CrossOrigin // set origins as needed
public class IntegrationController {
    private final IntegrationService service;

    public IntegrationController(IntegrationService service) {
        this.service = service;
    }

    @GetMapping
    public Page<IntegrationDto> list(
            @RequestParam(value = "q", required = false) String q,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        return service.list(q, page, size);
    }

    @GetMapping("/{id}")
    public IntegrationDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public IntegrationDto create(@RequestBody IntegrationDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public IntegrationDto update(@PathVariable Long id, @RequestBody IntegrationDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}