package com.example.notificationdemo.config;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.mail")
@Validated
public class MailProperties {

    @NotBlank(message = "Mail host cannot be empty")
private String host;

@Min(value = 1, message = "Mail port must be at least 1")
@Max(value = 65535, message = "Mail port cannot exceed 65535")
private int port;

@NotBlank(message = "Mail username cannot be empty")
private String username;

@NotBlank(message = "Mail password cannot be empty")
private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}