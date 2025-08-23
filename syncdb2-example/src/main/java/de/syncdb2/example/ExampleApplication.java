package de.syncdb2.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Beispielanwendung für syncdb2.
 */
@SpringBootApplication(scanBasePackages = "de.syncdb2")
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
