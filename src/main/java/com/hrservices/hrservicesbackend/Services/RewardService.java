package com.hrservices.hrservicesbackend.Services;

import com.hrservices.hrservicesbackend.DTO.RewardDto;
import com.hrservices.hrservicesbackend.Entity.RewardRecord;
import com.hrservices.hrservicesbackend.Repositories.EmployeeRepository;
import com.hrservices.hrservicesbackend.Repositories.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {
    private final RewardRepository repo;
    private final EmployeeRepository employeeRepo;

    public RewardService(RewardRepository repo, EmployeeRepository employeeRepo) {
        this.repo = repo; this.employeeRepo = employeeRepo;
    }

    public List<RewardDto> getAll() { return repo.findAll().stream().map(this::toDTO).toList(); }
    public RewardDto getById(Long id) { return toDTO(repo.findById(id).orElseThrow()); }
    public RewardDto create(RewardDto dto) { RewardRecord r = toEntity(dto); r.setId(null); return toDTO(repo.save(r)); }
    public RewardDto update(Long id, RewardDto dto) {
        RewardRecord r = repo.findById(id).orElseThrow();
        r.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElseThrow());
        r.setRewardTitle(dto.getRewardTitle()); r.setRewardDate(dto.getRewardDate()); r.setDescription(dto.getDescription());
        return toDTO(repo.save(r));
    }
    public void delete(Long id) { repo.deleteById(id); }

    private RewardDto toDTO(RewardRecord r) {
        RewardDto d = new RewardDto();
        d.setId(r.getId()); d.setEmployeeId(r.getEmployee().getId());
        d.setRewardTitle(r.getRewardTitle()); d.setRewardDate(r.getRewardDate()); d.setDescription(r.getDescription());
        return d;
    }
    private RewardRecord toEntity(RewardDto d) {
        RewardRecord r = new RewardRecord();
        r.setId(d.getId());
        r.setEmployee(employeeRepo.findById(d.getEmployeeId()).orElseThrow());
        r.setRewardTitle(d.getRewardTitle()); r.setRewardDate(d.getRewardDate()); r.setDescription(d.getDescription());
        return r;
    }
}