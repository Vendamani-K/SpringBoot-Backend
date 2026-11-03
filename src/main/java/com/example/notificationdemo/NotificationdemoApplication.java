
package com.example.notificationdemo;

import com.example.notificationdemo.config.MailProperties;
import com.example.notificationdemo.config.StorageProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import com.example.notificationdemo.scope.DemoBean;
import com.example.notificationdemo.service.NotificationManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.List;


@ConfigurationPropertiesScan
@SpringBootApplication
public class NotificationdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationdemoApplication.class, args);
    }
    @Bean
ApplicationRunner testDatabasePassword(
        @Value("${spring.datasource.password}") String password) {

    return args -> {
        System.out.println("Database password configured: "
                + !password.isEmpty());
    };
}

    @Bean
    CommandLineRunner run(
            NotificationManager manager,
            ApplicationContext context) {


        return args -> {
            System.out.println("\n--- Notification Demo ---");
            manager.notifyUser("Welcome to Spring Boot!");

            System.out.println("\n--- Singleton Scope ---");

            DemoBean singleton1 =
                    context.getBean("singletonBean", DemoBean.class);
            DemoBean singleton2 =
                    context.getBean("singletonBean", DemoBean.class);

            System.out.println("Same instance: "
                    + (singleton1 == singleton2));

            singleton1.showMessage();

            System.out.println("\n--- Prototype Scope ---");

            DemoBean prototype1 =
                    context.getBean("prototypeBean", DemoBean.class);
            DemoBean prototype2 =
                    context.getBean("prototypeBean", DemoBean.class);

            System.out.println("Same instance: "
                    + (prototype1 == prototype2));

            prototype1.showMessage();
            prototype2.showMessage();
        };
       
    }
   @Bean
ApplicationRunner applicationRunner() {
    return args -> {

        List<String> users = List.of("Alice", "Bob", "Charlie");

        System.out.println("--- Sample Users ---");

        users.forEach(System.out::println);
    };
}
@Bean
CommandLineRunner showConfiguration(
        MailProperties mail,
        StorageProperties storage) {

    return args -> {
        System.out.println("\n--- Mail Configuration ---");
        System.out.println("Host: " + mail.getHost());
        System.out.println("Port: " + mail.getPort());
        System.out.println("Username: " + mail.getUsername());

        System.out.println("\n--- Storage Configuration ---");
        System.out.println("Location: " + storage.getLocation());
        System.out.println("Max File Size: " + storage.getMaxFileSize());
    };
}
}

