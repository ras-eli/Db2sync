package de.syncdb2.mq.consumer;

/**
 * Listener zum Empfangen und Verarbeiten von Nachrichten.
 * @param <T> Nachrichtentyp
 */
public class SqljMessageListener<T> {

    private final SqljMessageDeserializer<T> deserializer;
    private final SqljMessageHandler<T> handler;

    public SqljMessageListener(SqljMessageDeserializer<T> deserializer, SqljMessageHandler<T> handler) {
        this.deserializer = deserializer;
        this.handler = handler;
    }

    /**
     * Wird aufgerufen, wenn eine neue Nachricht vorliegt.
     * @param payload Rohdaten
     */
    public void onMessage(String payload) {
        T msg = deserializer.deserialize(payload);
        handler.handle(msg);
    }
}
