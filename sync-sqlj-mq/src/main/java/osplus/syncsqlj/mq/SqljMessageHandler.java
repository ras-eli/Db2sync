package osplus.syncsqlj.mq;

/**
 * Verarbeitet empfangene Nachrichten.
 */
@FunctionalInterface
public interface SqljMessageHandler {
    /**
     * Bearbeitet die Nachricht.
     * @param message Nachricht
     */
    void handle(SqljMessage message);
}
