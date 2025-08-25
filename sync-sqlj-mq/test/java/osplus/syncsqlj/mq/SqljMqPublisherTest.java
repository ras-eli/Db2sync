package osplus.syncsqlj.mq;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;

class SqljMqPublisherTest {

    @Test
    void dispatchesMessage() {
        AtomicReference<SqljMessage> ref = new AtomicReference<>();
        SqljMqPublisher publisher = new SqljMqPublisher(ref::set);
        SqljMessage msg = new SqljMessage("payload");
        publisher.publish(msg);
        assertThat(ref.get()).isEqualTo(msg);
    }
}
