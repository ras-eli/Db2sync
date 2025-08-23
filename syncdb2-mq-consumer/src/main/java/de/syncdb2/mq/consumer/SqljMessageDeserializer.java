package de.syncdb2.mq.consumer;

/**
 * Wandelt eine Roh-Nachricht in ein Objekt um.
 * @param <T> Zieltyp
 */
@FunctionalInterface
public interface SqljMessageDeserializer<T> {
    T deserialize(String payload);
}
