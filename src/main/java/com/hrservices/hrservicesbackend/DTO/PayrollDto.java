package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class PayrollDto {
    private Long id; private Long employeeId; private String month;
    private BigDecimal salary; private BigDecimal bonus; private BigDecimal deductions;
    // getters/setters
}