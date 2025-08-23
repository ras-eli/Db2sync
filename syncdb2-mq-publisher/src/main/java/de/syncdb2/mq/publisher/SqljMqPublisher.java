package de.syncdb2.mq.publisher;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.event.TransactionPhase;

/**
 * Publiziert Nachrichten nach Commit der Transaktion.
 */
@Component
public class SqljMqPublisher {

    private final SqljMessageSender sender;

    public SqljMqPublisher(SqljMessageSender sender) {
        this.sender = sender;
    }

    /**
     * Versendet die Nachricht erst nach erfolgreichem Commit.
     * @param message Nachricht
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onMessage(SqljMessage message) {
        sender.send(message);
    }

    /**
     * Abstraktion des eigentlichen MQ-Senders.
     */
    public interface SqljMessageSender {
        void send(SqljMessage message);
    }
}
