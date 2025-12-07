package com.hrservices.hrservicesbackend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "rewards")
@Getter @Setter
public class RewardRecord {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name="employee_id")
    private Employee employee;
    private String rewardTitle;
    private LocalDate rewardDate;
    private String description;
    // getters/setters

}