# Architektur `syncdb2-mq-publisher`

Dieses Modul ermöglicht das Senden von MQ-Nachrichten nach Abschluss einer Datenbanktransaktion.

## Komponenten

- `SqljMessage` – einfacher Datenträger.
- `SqljMessageDispatcher` – veröffentlicht Nachrichten als Event.
- `SqljMqPublisher` – hört Events und sendet sie nach Commit.

## Sequenz

```mermaid
sequenceDiagram
    participant S as Service
    participant D as Dispatcher
    participant P as Publisher
    S->>D: dispatch(message)
    D->>P: Event
    P->>MQ: send(message)
```
