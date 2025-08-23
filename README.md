# 📦 Projekt: syncdb2

**syncdb2** ist ein modulares, transaktionssicheres SQLJ-Framework mit optionaler MQ-Integration. Es basiert auf Spring Boot und ist als autokonfigurierbare Library konzipiert.

## 📚 Architekturüberblick

Die folgenden Komponenten bilden das Kernsystem:

- **syncdb2-core**: Basisschicht für SQLJ-Objekte und kontrollierte Ausführung innerhalb von Transaktionen.
- **syncdb2-mq-publisher**: Integration mit MQ-Systemen (z.B. Kafka, RabbitMQ) mit Dual-Commit-Support.
- **syncdb2-mq-consumer**: Konsum von Nachrichten, Wiederherstellung des SQLJ-Kontexts und Weiterleitung an Executor.
- **syncdb2-starter**: Autokonfiguration zur einfachen Einbindung in Spring Boot Anwendungen.
- **syncdb2-example**: Beispielprojekt zur praktischen Nutzung und Verifikation von Funktionalität.

## 🗂 Enthaltene Dokumentationen

- [Benutzerhandbuch](docs/Benutzerhandbuch.md)
- [Entwickler-Guide](docs/ENTWICKLER-GUIDE.md)
- [Gesamtarchitektur von syncdb2](docs/Syncdb2-Gesamtarchitektur.md)

## ✅ Status

Alle Module wurden modular aufgebaut. CI/CD mit GitHub Actions ist eingerichtet. Weitere Details siehe [docs/](./docs/).
