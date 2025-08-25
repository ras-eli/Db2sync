# Architektur

Diese Bibliothek ist in drei Schichten unterteilt:

- **core**: Ausführung von SQLJ in Transaktionen.
- **mq**: Versand und Empfang von MQ-Nachrichten.
- **service**: Koordiniert Datenbankoperation und MQ.

Die Datenbanken werden über zwei HikariCP DataSources angesprochen.
