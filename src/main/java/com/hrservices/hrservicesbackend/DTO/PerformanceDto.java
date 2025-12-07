package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PerformanceDto {
    private Long id; private Long employeeId; private String reviewPeriod; private Integer rating; private String comments;
    // getters/setters
}