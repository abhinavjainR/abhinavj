package com.hrservices.hrservicesbackend.Services;

import com.hrservices.hrservicesbackend.DTO.PayrollDto;
import com.hrservices.hrservicesbackend.Entity.PayrollRecord;
import com.hrservices.hrservicesbackend.Repositories.EmployeeRepository;
import com.hrservices.hrservicesbackend.Repositories.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
    private final PayrollRepository repo;
    private final EmployeeRepository employeeRepo;

    public PayrollService(PayrollRepository repo, EmployeeRepository employeeRepo) {
        this.repo = repo; this.employeeRepo = employeeRepo;
    }

    public List<PayrollDto> getAll() { return repo.findAll().stream().map(this::toDTO).toList(); }
    public PayrollDto getById(Long id) { return toDTO(repo.findById(id).orElseThrow()); }
    public PayrollDto create(PayrollDto dto) { PayrollRecord p = toEntity(dto); p.setId(null); return toDTO(repo.save(p)); }
    public PayrollDto update(Long id, PayrollDto dto) {
        PayrollRecord p = repo.findById(id).orElseThrow();
        p.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElseThrow());
        p.setMonth(dto.getMonth()); p.setSalary(dto.getSalary());
        p.setBonus(dto.getBonus()); p.setDeductions(dto.getDeductions());
        return toDTO(repo.save(p));
    }
    public void delete(Long id) { repo.deleteById(id); }

    private PayrollDto toDTO(PayrollRecord p) {
        PayrollDto d = new PayrollDto();
        d.setId(p.getId()); d.setEmployeeId(p.getEmployee().getId());
        d.setMonth(p.getMonth()); d.setSalary(p.getSalary());
        d.setBonus(p.getBonus()); d.setDeductions(p.getDeductions());
        return d;
    }
    private PayrollRecord toEntity(PayrollDto d) {
        PayrollRecord p = new PayrollRecord();
        p.setId(d.getId());
        p.setEmployee(employeeRepo.findById(d.getEmployeeId()).orElseThrow());
        p.setMonth(d.getMonth()); p.setSalary(d.getSalary());
        p.setBonus(d.getBonus()); p.setDeductions(d.getDeductions());
        return p;
    }
}