# Benutzerhandbuch

Dieses Handbuch beschreibt die Verwendung der Bibliothek `syncdb2`.

## Installation

Fügen Sie die folgenden Abhängigkeiten zu Ihrer `pom.xml` hinzu:

```xml
<dependency>
  <groupId>de.syncdb2</groupId>
  <artifactId>syncdb2-starter</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Verwendung

1. Implementieren Sie ein `SqljObject` mit der gewünschten SQL-Logik.
2. Injizieren Sie `SqljExecutor` und `SqljMessageDispatcher`.
3. Rufen Sie `SqljExecutor.execute()` innerhalb einer Transaktion auf und verwenden Sie `SqljMessageDispatcher.dispatch()` zum Versenden von Nachrichten.

## Beispiel

Siehe Modul `syncdb2-example` für eine vollständige Anwendung.
