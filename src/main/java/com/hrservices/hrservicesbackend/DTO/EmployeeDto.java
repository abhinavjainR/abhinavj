package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDto {
        private Long id;
        private String name;
        private String email;
        private String department;
        private String role;
        private String phone;
        private String address;
        // getters/setters
}