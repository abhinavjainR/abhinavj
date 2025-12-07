package com.hrservices.hrservicesbackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "integrations")
public class IntegrationRecord {
    // Getters/setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String systemName;
    @Column(nullable = false, unique = true) private String apiKey;

    @Column(nullable = false) private boolean connected = false;
    private LocalDateTime connectedOn;

    // Optional metadata
    private String description;
    private String logoUrl;
}