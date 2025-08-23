package de.syncdb2.example;

import de.syncdb2.core.SqljExecutor;
import de.syncdb2.mq.publisher.SqljMessage;
import de.syncdb2.mq.publisher.SqljMessageDispatcher;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Führt eine Beispieltransaktion aus und sendet danach eine MQ-Nachricht.
 */
@Service
public class ExampleService {

    private final SqljExecutor executor;
    private final SqljMessageDispatcher dispatcher;

    public ExampleService(SqljExecutor executor, SqljMessageDispatcher dispatcher) {
        this.executor = executor;
        this.dispatcher = dispatcher;
    }

    /**
     * Führt Beispiel-SQL aus und versendet eine Nachricht.
     */
    @Transactional
    public void runExample() {
        executor.execute(conn -> {
            try (Statement st = conn.createStatement()) {
                st.execute("CREATE TABLE beispiel(id INT PRIMARY KEY, name VARCHAR(50))");
                st.executeUpdate("INSERT INTO beispiel(id, name) VALUES (1, 'Beispiel')");
            }
            return 1;
        });
        dispatcher.dispatch(new SqljMessage("Beispiel"));
    }
}
