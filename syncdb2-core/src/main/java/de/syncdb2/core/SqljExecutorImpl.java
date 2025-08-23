package de.syncdb2.core;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Standardimplementierung des {@link SqljExecutor}.
 */
@Component
public class SqljExecutorImpl implements SqljExecutor {

    private final DataSource dataSource;

    public SqljExecutorImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Transactional
    public <T> T execute(SqljObject<T> sqljObject) {
        Connection connection = ConnectionUtils.getConnection(dataSource);
        try {
            return sqljObject.execute(connection);
        } catch (SQLException ex) {
            throw new RuntimeException("SQL-Fehler", ex);
        }
    }
}
