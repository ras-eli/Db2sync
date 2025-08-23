package de.syncdb2.example;

import static org.assertj.core.api.Assertions.assertThat;

import de.syncdb2.mq.publisher.SqljMessage;
import de.syncdb2.mq.publisher.SqljMqPublisher;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Integrationstest für die Beispielanwendung.
 */
@SpringBootTest
class ExampleApplicationTest {

    @Autowired
    private ExampleService service;

    @Autowired
    private RecordingSender sender;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void fuehrtBeispielAus() {
        service.runExample();
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM beispiel", Integer.class);
        assertThat(count).isEqualTo(1);
        assertThat(sender.messages).containsExactly(new SqljMessage("Beispiel"));
    }

    @TestConfiguration
    static class Config {
        @Bean
        RecordingSender recordingSender() {
            return new RecordingSender();
        }

        @Bean
        SqljMqPublisher.SqljMessageSender sender(RecordingSender recordingSender) {
            return recordingSender;
        }
    }

    static class RecordingSender implements SqljMqPublisher.SqljMessageSender {
        final List<SqljMessage> messages = new ArrayList<>();
        @Override
        public void send(SqljMessage message) {
            messages.add(message);
        }
    }
}
