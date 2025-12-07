package com.hrservices.hrservicesbackend.Repositories;

import com.hrservices.hrservicesbackend.Entity.PayrollRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayrollRepository extends JpaRepository<PayrollRecord, Long> {
    List<PayrollRecord> findByEmployeeId(Long employeeId);
    List<PayrollRecord> findByMonth(String month);
    List<PayrollRecord> findBySalaryGreaterThan(Double salary);
}
