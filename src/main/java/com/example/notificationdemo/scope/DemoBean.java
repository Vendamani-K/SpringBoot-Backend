
package com.example.notificationdemo.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class DemoBean {

    private final String beanName;

    public DemoBean(String beanName) {
        this.beanName = beanName;
        System.out.println(beanName + " constructor called");
    }

    @PostConstruct
    public void initialize() {
        System.out.println(beanName + " initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(beanName + " destroyed");
    }

    public void showMessage() {
        System.out.println("Using " + beanName);
    }
}
