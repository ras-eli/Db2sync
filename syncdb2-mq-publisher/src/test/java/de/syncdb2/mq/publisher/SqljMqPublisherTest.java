package de.syncdb2.mq.publisher;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Testet den MQ-Publisher.
 */
@SpringBootTest
class SqljMqPublisherTest {

    @Autowired
    private SqljMessageDispatcher dispatcher;

    @Autowired
    private RecordingSender sender;

    @Autowired
    private PlatformTransactionManager txManager;

    @Test
    void sendetNachCommit() {
        TransactionTemplate template = new TransactionTemplate(txManager);
        template.executeWithoutResult(status -> dispatcher.dispatch(new SqljMessage("hallo")));
        assertThat(sender.messages).containsExactly(new SqljMessage("hallo"));
    }

    @TestConfiguration
    static class Config {
        @Bean
        DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        }

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
