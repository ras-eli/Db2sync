package osplus.syncsqlj.mq;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Liest Nachrichten mittels DB2-Prozedur und verarbeitet sie.
 */
public class SqljMessageListener {

    private final SqljMessageDeserializer deserializer;
    private final SqljMessageHandler handler;

    public SqljMessageListener(SqljMessageDeserializer deserializer, SqljMessageHandler handler) {
        this.deserializer = deserializer;
        this.handler = handler;
    }

    @Scheduled(fixedDelay = 1000)
    public void poll() {
        String json = receive();
        SqljMessage message = deserializer.deserialize(json);
        handler.handle(message);
    }

    String receive() {
        // Stub für DB2MQ.MQRECEIVE
        return "{}";
    }
}
