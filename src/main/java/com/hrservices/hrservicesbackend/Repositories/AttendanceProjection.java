package com.hrservices.hrservicesbackend.Repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AttendanceProjection {
    Long getId();
    Long getEmployeeId();
    String getEmployeeName();
    LocalDate getDate();
    String getStatus();
    LocalDateTime getCheckIn();
    LocalDateTime getCheckOut();

}
