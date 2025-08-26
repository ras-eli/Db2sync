package osplus.syncsqlj.service;

import org.springframework.context.ApplicationEventPublisher;

import osplus.syncsqlj.core.SqljExecutor;
import osplus.syncsqlj.core.SqljObject;
import osplus.syncsqlj.mq.SqljMessage;

/**
 * Koordiniert SQLJ-Ausführung und MQ-Versand.
 */
public class SqljService {

    private final SqljExecutor executor;
    private final ApplicationEventPublisher publisher;

    public SqljService(SqljExecutor executor, ApplicationEventPublisher publisher) {
        this.executor = executor;
        this.publisher = publisher;
    }

    /**
     * Führt das Objekt aus und versendet anschließend die Nachricht.
     */
    public <T> T executeAndSend(SqljObject<T> object, SqljMessage message) {
        T result = executor.run(object);
        publisher.publishEvent(message);
        return result;
    }
}
