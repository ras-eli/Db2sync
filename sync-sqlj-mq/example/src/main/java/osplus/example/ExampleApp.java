package osplus.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import osplus.syncsqlj.core.SqljObject;
import osplus.syncsqlj.mq.SqljMessage;
import osplus.syncsqlj.service.SqljService;

/**
 * Kleine Demo-Anwendung.
 */
@SpringBootApplication
public class ExampleApp {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }

    @Bean
    CommandLineRunner demo(SqljService service) {
        return args -> {
            SqljObject<Integer> obj = conn -> 1; // Stub
            service.executeAndSend(obj, new SqljMessage("demo"));
        };
    }
}
