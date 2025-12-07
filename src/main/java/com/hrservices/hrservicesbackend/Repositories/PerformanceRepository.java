package com.hrservices.hrservicesbackend.Repositories;

import com.hrservices.hrservicesbackend.Entity.PerformanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PerformanceRepository extends JpaRepository<PerformanceRecord, Long> {
    List<PerformanceRecord> findByReviewPeriod(String reviewPeriod);
    List<PerformanceRecord> findByRating(Integer rating);
}
