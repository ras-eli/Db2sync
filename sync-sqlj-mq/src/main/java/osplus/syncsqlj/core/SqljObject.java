package osplus.syncsqlj.core;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Ein zu ausführendes SQLJ-Objekt.
 * @param <T> Rückgabetyp
 */
@FunctionalInterface
public interface SqljObject<T> {
    /**
     * Führt SQLJ-Code mit gegebener Verbindung aus.
     * @param connection JDBC-Verbindung
     * @return Ergebnis des SQLJ-Aufrufs
     * @throws SQLException bei Fehlern
     */
    T execute(Connection connection) throws SQLException;
}
