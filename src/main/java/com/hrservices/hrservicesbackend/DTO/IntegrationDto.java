package com.hrservices.hrservicesbackend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class IntegrationDto {
    public Long id;
    public String systemName;
    public String apiKey;
    public boolean connected;
    public LocalDateTime connectedOn;
    public String description;
    public String logoUrl;

}