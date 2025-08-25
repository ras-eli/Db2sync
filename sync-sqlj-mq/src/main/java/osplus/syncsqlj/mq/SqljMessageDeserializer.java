package osplus.syncsqlj.mq;

/**
 * Deserialisiert JSON in {@link SqljMessage}.
 */
@FunctionalInterface
public interface SqljMessageDeserializer {
    /**
     * Wandelt JSON in eine Nachricht um.
     * @param json Eingabe
     * @return Nachricht
     */
    SqljMessage deserialize(String json);
}
