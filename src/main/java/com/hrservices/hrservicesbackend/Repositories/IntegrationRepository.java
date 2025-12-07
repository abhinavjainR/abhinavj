package com.hrservices.hrservicesbackend.Repositories;

import com.hrservices.hrservicesbackend.Entity.IntegrationRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrationRepository extends JpaRepository<IntegrationRecord, Long> {
    Page<IntegrationRecord> findBySystemNameContainingIgnoreCase(String q, Pageable pageable);
    Page<IntegrationRecord> findBySystemNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String systemName, String description, Pageable pageable
    );
}
