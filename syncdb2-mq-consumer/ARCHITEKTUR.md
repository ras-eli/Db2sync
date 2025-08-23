# Architektur `syncdb2-mq-consumer`

Dieses Modul stellt Listener-Komponenten für den Empfang von MQ-Nachrichten bereit.

## Komponenten

- `SqljMessageDeserializer` – wandelt Rohdaten um.
- `SqljMessageHandler` – verarbeitet Nachrichten.
- `SqljMessageListener` – verbindet beides.

## Sequenz

```mermaid
sequenceDiagram
    participant L as Listener
    participant D as Deserializer
    participant H as Handler
    L->>D: deserialize
    D-->>L: Nachricht
    L->>H: handle
```
