package com.hrservices.hrservicesbackend.DTO;

import java.time.LocalDateTime;

public class
IntegrationDto {
    public Long id;
    public String systemName;
    public String apiKey;
    public boolean connected;
    public LocalDateTime connectedOn;
    public String description;
    public String logoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public LocalDateTime getConnectedOn() {
        return connectedOn;
    }

    public void setConnectedOn(LocalDateTime connectedOn) {
        this.connectedOn = connectedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}