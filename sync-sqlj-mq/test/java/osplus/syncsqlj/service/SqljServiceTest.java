package osplus.syncsqlj.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import osplus.syncsqlj.core.SqljExecutor;
import osplus.syncsqlj.core.SqljObject;
import osplus.syncsqlj.mq.SqljMessage;

class SqljServiceTest {

    @Test
    void executesAndPublishes() {
        SqljExecutor exec = object -> {
            try {
                return object.execute((Connection) null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        List<Object> events = new ArrayList<>();
        ApplicationEventPublisher publisher = events::add;
        SqljService service = new SqljService(exec, publisher);
        SqljMessage message = new SqljMessage("demo");
        Integer res = service.executeAndSend(conn -> 7, message);
        assertThat(res).isEqualTo(7);
        assertThat(events).containsExactly(message);
    }
}
