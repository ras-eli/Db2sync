package de.syncdb2.mq.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Veröffentlicht Nachrichten als Spring-Ereignis.
 */
@Component
public class SqljMessageDispatcher {

    private final ApplicationEventPublisher publisher;

    public SqljMessageDispatcher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * Publiziert die Nachricht.
     * @param message Nachricht
     */
    public void dispatch(SqljMessage message) {
        publisher.publishEvent(message);
    }
}
