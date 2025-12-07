package com.hrservices.hrservicesbackend.Repositories;

import com.hrservices.hrservicesbackend.Entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskItem, Long> {
    List<TaskItem> findByEmployeeId(Long employeeId);
    List<TaskItem> findByStatus(String status);
    List<TaskItem> findByDueDate(String dueDate);
}
