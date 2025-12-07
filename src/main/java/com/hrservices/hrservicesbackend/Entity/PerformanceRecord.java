package com.hrservices.hrservicesbackend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "performance")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PerformanceRecord {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne @JoinColumn(name="employee_id") private Employee employee;
    private String reviewPeriod; private Integer rating; private String comments;
    // getters/setters

}