package com.hrservices.hrservicesbackend.Services;
// com.example.hr.employee.EmployeeService.java

import com.hrservices.hrservicesbackend.DTO.EmployeeDto;
import com.hrservices.hrservicesbackend.Entity.Employee;
import com.hrservices.hrservicesbackend.Repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<EmployeeDto> getAll() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public EmployeeDto getById(Long id) {
        return toDTO(repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found")));
    }

    public EmployeeDto create(EmployeeDto dto) {
        Employee e = toEntity(dto);
        e.setId(null);
        return toDTO(repo.save(e));
    }

    public EmployeeDto update(Long id, EmployeeDto dto) {
        Employee e = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        e.setRole(dto.getRole());
        e.setPhone(dto.getPhone());
        e.setAddress(dto.getAddress());
        return toDTO(repo.save(e));
    }

    public void delete(Long id) { repo.deleteById(id); }

    private EmployeeDto toDTO(Employee e) {
        EmployeeDto d = new EmployeeDto();
        d.setId(e.getId()); d.setName(e.getName()); d.setEmail(e.getEmail());
        d.setDepartment(e.getDepartment()); d.setRole(e.getRole());
        d.setPhone(e.getPhone()); d.setAddress(e.getAddress()); return d;
    }

    private Employee toEntity(EmployeeDto d) {
        Employee e = new Employee();
        e.setId(d.getId()); e.setName(d.getName()); e.setEmail(d.getEmail());
        e.setDepartment(d.getDepartment()); e.setRole(d.getRole());
        e.setPhone(d.getPhone()); e.setAddress(d.getAddress()); return e;
    }
}