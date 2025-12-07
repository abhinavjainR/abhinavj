package com.hrservices.hrservicesbackend.Repositories;

import com.hrservices.hrservicesbackend.Entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Long> {
    List<AttendanceRecord> findByEmployeeId(Long employeeId);
    List<AttendanceRecord> findByDate(LocalDate date);
    List<AttendanceRecord> findByStatus(String status);

}
