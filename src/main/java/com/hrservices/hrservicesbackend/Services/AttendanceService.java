package com.hrservices.hrservicesbackend.Services;
// com.example.hr.attendance.AttendanceService.java

import com.hrservices.hrservicesbackend.DTO.AttendanceDto;
import com.hrservices.hrservicesbackend.Entity.AttendanceRecord;
import com.hrservices.hrservicesbackend.Repositories.AttendanceRepository;
import com.hrservices.hrservicesbackend.Repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository repo;
    private final EmployeeRepository employeeRepo;

    public AttendanceService(AttendanceRepository repo, EmployeeRepository employeeRepo) {
        this.repo = repo; this.employeeRepo = employeeRepo;
    }

    public List<AttendanceDto> getAll() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public AttendanceDto getById(Long id) {
        return toDTO(repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendance not found")));
    }

    public AttendanceDto create(AttendanceDto dto) {
        AttendanceRecord a = toEntity(dto);
        a.setId(null);
        return toDTO(repo.save(a));
    }

    public AttendanceDto update(Long id, AttendanceDto dto) {
        AttendanceRecord a = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendance not found"));
        a.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElseThrow(() -> new EntityNotFoundException("Employee not found")));
        a.setDate(dto.getDate()); a.setStatus(dto.getStatus());
        a.setCheckIn(dto.getCheckIn()); a.setCheckOut(dto.getCheckOut());
        return toDTO(repo.save(a));
    }

    public void delete(Long id) { repo.deleteById(id); }

    private AttendanceDto toDTO(AttendanceRecord a) {
        AttendanceDto d = new AttendanceDto();
        d.setId(a.getId());
        d.setEmployeeId(a.getEmployee().getId());
        d.setDate(a.getDate()); d.setStatus(a.getStatus());
        d.setCheckIn(a.getCheckIn()); d.setCheckOut(a.getCheckOut());
        return d;
    }

    private AttendanceRecord toEntity(AttendanceDto d) {
        AttendanceRecord a = new AttendanceRecord();
        a.setId(d.getId());
        a.setEmployee(employeeRepo.findById(d.getEmployeeId()).orElseThrow(() -> new EntityNotFoundException("Employee not found")));
        a.setDate(d.getDate()); a.setStatus(d.getStatus());
        a.setCheckIn(d.getCheckIn()); a.setCheckOut(d.getCheckOut());
        return a;
    }
}