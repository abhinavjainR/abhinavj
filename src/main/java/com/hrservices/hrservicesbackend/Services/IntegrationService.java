package com.hrservices.hrservicesbackend.Services;

import com.hrservices.hrservicesbackend.DTO.IntegrationDto;
import com.hrservices.hrservicesbackend.Entity.IntegrationRecord;
import com.hrservices.hrservicesbackend.Repositories.IntegrationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IntegrationService {
    private final IntegrationRepository repo;

    public IntegrationService(IntegrationRepository repo) {
        this.repo = repo;
    }

    public Page<IntegrationDto> list(String q, int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        Page<IntegrationRecord> p;

        if (q == null || q.isBlank()) {
            p = repo.findAll(pr);
        } else {
            // Search across multiple fields
            p = repo.findBySystemNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(q, q, pr);
        }

        return p.map(this::toDto);
    }

    public IntegrationDto get(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Integration not found"));
    }

    public IntegrationDto create(IntegrationDto dto) {
        IntegrationRecord e = new IntegrationRecord();
        e.setSystemName(dto.systemName);
        e.setApiKey(dto.apiKey);
        e.setDescription(dto.description);
        e.setLogoUrl(dto.logoUrl);
        e.setConnected(false);
        e.setConnectedOn(null);
        return toDto(repo.save(e));
    }

    public IntegrationDto update(Long id, IntegrationDto dto) {
        IntegrationRecord e = repo.findById(id).orElseThrow(() -> new RuntimeException("Integration not found"));
        if (dto.systemName != null) e.setSystemName(dto.systemName);
        if (dto.apiKey != null) e.setApiKey(dto.apiKey);
        if (dto.description != null) e.setDescription(dto.description);
        if (dto.logoUrl != null) e.setLogoUrl(dto.logoUrl);

        // Connect/disconnect toggle
        if (dto.connected != e.isConnected()) {
            e.setConnected(dto.connected);
            e.setConnectedOn(dto.connected ? LocalDateTime.now() : null);
        }
        return toDto(repo.save(e));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private IntegrationDto toDto(IntegrationRecord e) {
        IntegrationDto d = new IntegrationDto();
        d.id = e.getId();
        d.systemName = e.getSystemName();
        d.apiKey = e.getApiKey();
        d.connected = e.isConnected();
        d.connectedOn = e.getConnectedOn();
        d.description = e.getDescription();
        d.logoUrl = e.getLogoUrl();
        return d;
    }
}