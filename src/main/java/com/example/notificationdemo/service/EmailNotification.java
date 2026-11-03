
package com.example.notificationdemo.service;

import org.springframework.stereotype.Component;

@Component("emailNotification")
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email: " + message);
    }
}
