package osplus.syncsqlj.core;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import osplus.syncsqlj.util.ConnectionUtils;

/**
 * Standardimplementierung des {@link SqljExecutor}.
 */
@Service
public class SqljExecutorImpl implements SqljExecutor {

    private final DataSource dataSource;

    public SqljExecutorImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Transactional
    public <T> T run(SqljObject<T> object) {
        try (Connection connection = ConnectionUtils.getConnection(dataSource)) {
            return object.execute(connection);
        } catch (SQLException ex) {
            throw new IllegalStateException("SQLJ-Ausführung fehlgeschlagen", ex);
        }
    }
}
