package osplus.syncsqlj.mq;

/**
 * Abstraktion für MQ-Dispatching.
 */
@FunctionalInterface
public interface SqljMessageDispatcher {
    /**
     * Versendet die Nachricht.
     * @param message MQ-Nachricht
     */
    void dispatch(SqljMessage message);
}
