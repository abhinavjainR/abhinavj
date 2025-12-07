package com.hrservices.hrservicesbackend.Services;

import com.hrservices.hrservicesbackend.DTO.TaskDto;
import com.hrservices.hrservicesbackend.Entity.TaskItem;
import com.hrservices.hrservicesbackend.Repositories.EmployeeRepository;
import com.hrservices.hrservicesbackend.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;
    private final EmployeeRepository employeeRepo;

    public TaskService(TaskRepository repo, EmployeeRepository employeeRepo) {
        this.repo = repo; this.employeeRepo = employeeRepo;
    }

    public List<TaskDto> getAll() { return repo.findAll().stream().map(this::toDTO).toList(); }
    public TaskDto getById(Long id) { return toDTO(repo.findById(id).orElseThrow()); }
    public TaskDto create(TaskDto dto) { TaskItem t = toEntity(dto); t.setId(null); return toDTO(repo.save(t)); }
    public TaskDto update(Long id, TaskDto dto) {
        TaskItem t = repo.findById(id).orElseThrow();
        t.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElseThrow());
        t.setTaskTitle(dto.getTaskTitle()); t.setDueDate(dto.getDueDate()); t.setStatus(dto.getStatus());
        return toDTO(repo.save(t));
    }
    public void delete(Long id) { repo.deleteById(id); }

    private TaskDto toDTO(TaskItem t) {
        TaskDto d = new TaskDto();
        d.setId(t.getId()); d.setEmployeeId(t.getEmployee().getId());
        d.setTaskTitle(t.getTaskTitle()); d.setDueDate(t.getDueDate()); d.setStatus(t.getStatus());
        return d;
    }
    private TaskItem toEntity(TaskDto d) {
        TaskItem t = new TaskItem();
        t.setId(d.getId());
        t.setEmployee(employeeRepo.findById(d.getEmployeeId()).orElseThrow());
        t.setTaskTitle(d.getTaskTitle()); t.setDueDate(d.getDueDate()); t.setStatus(d.getStatus());
        return t;
    }
}