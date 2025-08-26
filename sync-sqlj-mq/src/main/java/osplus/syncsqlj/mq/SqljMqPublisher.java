package osplus.syncsqlj.mq;

import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.event.TransactionPhase;

/**
 * Versendet Nachrichten nach erfolgreichem Commit.
 */
public class SqljMqPublisher {

    private final SqljMessageDispatcher dispatcher;

    public SqljMqPublisher(SqljMessageDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void publish(SqljMessage message) {
        dispatcher.dispatch(message);
    }
}
