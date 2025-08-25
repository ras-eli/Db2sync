package osplus.syncsqlj.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqljExecutorImplTest {

    @Autowired
    SqljExecutor executor;

    @Test
    void executesObject() {
        Integer result = executor.run(conn -> 42);
        assertThat(result).isEqualTo(42);
    }
}
