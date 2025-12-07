package com.hrservices.hrservicesbackend.Services;

import com.hrservices.hrservicesbackend.DTO.PerformanceDto;
import com.hrservices.hrservicesbackend.Entity.PerformanceRecord;
import com.hrservices.hrservicesbackend.Repositories.EmployeeRepository;
import com.hrservices.hrservicesbackend.Repositories.PerformanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    private final PerformanceRepository repo;
    private final EmployeeRepository employeeRepo;

    public PerformanceService(PerformanceRepository repo, EmployeeRepository employeeRepo) {
        this.repo = repo; this.employeeRepo = employeeRepo;
    }

    public List<PerformanceDto> getAll() { return repo.findAll().stream().map(this::toDTO).toList(); }
    public PerformanceDto getById(Long id) { return toDTO(repo.findById(id).orElseThrow()); }
    public PerformanceDto create(PerformanceDto dto) { PerformanceRecord p = toEntity(dto); p.setId(null); return toDTO(repo.save(p)); }
    public PerformanceDto update(Long id, PerformanceDto dto) {
        PerformanceRecord p = repo.findById(id).orElseThrow();
        p.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElseThrow());
        p.setReviewPeriod(dto.getReviewPeriod()); p.setRating(dto.getRating()); p.setComments(dto.getComments());
        return toDTO(repo.save(p));
    }
    public void delete(Long id) { repo.deleteById(id); }

    private PerformanceDto toDTO(PerformanceRecord p) {
        PerformanceDto d = new PerformanceDto();
        d.setId(p.getId()); d.setEmployeeId(p.getEmployee().getId());
        d.setReviewPeriod(p.getReviewPeriod()); d.setRating(p.getRating()); d.setComments(p.getComments());
        return d;
    }
    private PerformanceRecord toEntity(PerformanceDto d) {
        PerformanceRecord p = new PerformanceRecord();
        p.setId(d.getId());
        p.setEmployee(employeeRepo.findById(d.getEmployeeId()).orElseThrow());
        p.setReviewPeriod(d.getReviewPeriod()); p.setRating(d.getRating()); p.setComments(d.getComments());
        return p;
    }
}