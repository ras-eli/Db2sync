package osplus.syncsqlj.mq;

/**
 * Einfache MQ-Nachricht.
 */
public class SqljMessage {

    private final String payload;

    public SqljMessage(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}
