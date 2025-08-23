package de.syncdb2.mq.consumer;

import static org.assertj.core.api.Assertions.assertThat;

import de.syncdb2.mq.publisher.SqljMessage;
import org.junit.jupiter.api.Test;

/**
 * Test für den Listener.
 */
class SqljMessageListenerTest {

    @Test
    void deserialisiertUndVerarbeitet() {
        FakeDeserializer deserializer = new FakeDeserializer();
        TestHandler handler = new TestHandler();
        SqljMessageListener<SqljMessage> listener = new SqljMessageListener<>(deserializer, handler);
        listener.onMessage("payload");
        assertThat(handler.message.payload()).isEqualTo("payload");
    }

    static class FakeDeserializer implements SqljMessageDeserializer<SqljMessage> {
        @Override
        public SqljMessage deserialize(String payload) {
            return new SqljMessage(payload);
        }
    }

    static class TestHandler implements SqljMessageHandler<SqljMessage> {
        SqljMessage message;
        @Override
        public void handle(SqljMessage message) {
            this.message = message;
        }
    }
}
