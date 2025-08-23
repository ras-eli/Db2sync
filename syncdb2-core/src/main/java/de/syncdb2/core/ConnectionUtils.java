package de.syncdb2.core;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * Hilfsmethoden rund um Verbindungen.
 */
public final class ConnectionUtils {

    private ConnectionUtils() {
    }

    /**
     * Liefert eine transaktionsbewusste Verbindung.
     * @param dataSource Datenquelle
     * @return Verbindung
     */
    public static Connection getConnection(DataSource dataSource) {
        return DataSourceUtils.getConnection(dataSource);
    }
}
