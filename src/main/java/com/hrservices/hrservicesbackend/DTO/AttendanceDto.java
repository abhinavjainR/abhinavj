package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter @Setter
public class AttendanceDto {
    private Long id;
    private Long employeeId;
    private LocalDate date;
    private String status;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

}