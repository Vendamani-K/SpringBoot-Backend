
package com.example.notificationdemo.config;

import com.example.notificationdemo.scope.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    public DemoBean singletonBean() {
        return new DemoBean("Singleton Bean");
    }

    @Bean
    @Scope("prototype")
    public DemoBean prototypeBean() {
        return new DemoBean("Prototype Bean");
    }
}
