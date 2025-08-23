package de.syncdb2.mq.consumer;

/**
 * Verarbeitet eine deserialisierte Nachricht.
 * @param <T> Nachrichtentyp
 */
@FunctionalInterface
public interface SqljMessageHandler<T> {
    void handle(T message);
}
