package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class RewardDto {
    private Long id;
    private Long employeeId;
    private String rewardTitle;
    private LocalDate rewardDate;
    private String description;
    // getters/setters
}