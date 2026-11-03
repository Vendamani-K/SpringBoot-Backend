package com.example.notificationdemo.config;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.storage")
@Validated
public class StorageProperties {

    @NotBlank(message = "Storage location cannot be empty")
private String location;

@NotBlank(message = "Maximum file size cannot be empty")
private String maxFileSize;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
}