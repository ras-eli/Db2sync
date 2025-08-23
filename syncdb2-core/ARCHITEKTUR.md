# Architektur `syncdb2-core`

Dieses Modul stellt die Grundfunktionen zur Ausführung von SQLJ innerhalb einer Spring-Transaktion bereit.

## Komponenten

- `SqljObject` – Funktionsschnittstelle für SQLJ-Ausführungen.
- `SqljExecutor` – Abstraktion zur Ausführung.
- `SqljExecutorImpl` – Implementierung mit `@Transactional`.
- `ConnectionUtils` – Hilfsklasse für transaktionsbewusste Verbindungen.

## Ablauf

```mermaid
sequenceDiagram
    participant S as Service
    participant E as SqljExecutor
    participant DB as Datenbank
    S->>E: execute(SqljObject)
    E->>DB: SQL ausführen
    DB-->>E: Ergebnis
    E-->>S: Rückgabe
```
