package de.syncdb2.core;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Repräsentiert ein auszuführendes SQLJ-Objekt.
 * @param <T> Ergebnistyp
 */
@FunctionalInterface
public interface SqljObject<T> {

    /**
     * Führt die eigentliche SQL-Logik aus.
     * @param connection aktive JDBC-Verbindung
     * @return Ergebnis des SQL-Aufrufs
     * @throws SQLException bei Fehlern
     */
    T execute(Connection connection) throws SQLException;
}
