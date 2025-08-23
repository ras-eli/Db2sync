package de.syncdb2.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Statement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Testet die Ausführung eines einfachen SQLJ-Objekts.
 */
@SpringBootTest
@Import({TestDataSourceConfig.class})
class SqljExecutorImplTest {

    @Autowired
    private SqljExecutor executor;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void fuehrtSqlAus() {
        executor.execute(conn -> {
            try (Statement st = conn.createStatement()) {
                st.execute("CREATE TABLE demo(id INT PRIMARY KEY, name VARCHAR(50))");
                st.executeUpdate("INSERT INTO demo(id, name) VALUES (1, 'test')");
            }
            return 1;
        });
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM demo", Integer.class);
        assertThat(count).isEqualTo(1);
    }
}
