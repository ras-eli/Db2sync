package osplus.syncsqlj.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Hilfsmethoden rund um JDBC-Verbindungen.
 */
public final class ConnectionUtils {

    private ConnectionUtils() {
    }

    /**
     * Liefert eine neue Verbindung aus dem DataSource-Pool.
     * @param dataSource Datenquelle
     * @return aktive JDBC-Verbindung
     * @throws SQLException bei Fehlern
     */
    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }
}
