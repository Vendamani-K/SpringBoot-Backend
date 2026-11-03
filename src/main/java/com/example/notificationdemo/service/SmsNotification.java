
package com.example.notificationdemo.service;

import org.springframework.stereotype.Component;

@Component("smsNotification")
public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
