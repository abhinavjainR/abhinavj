package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class TaskDto {
    private Long id; private Long employeeId; private String taskTitle; private LocalDate dueDate; private String status;
    // getters/setters
}