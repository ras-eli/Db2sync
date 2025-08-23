package de.syncdb2.starter;

import javax.sql.DataSource;
import de.syncdb2.core.SqljExecutor;
import de.syncdb2.core.SqljExecutorImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-Konfiguration für den {@link SqljExecutor}.
 */
@Configuration
public class SyncDb2AutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SqljExecutor sqljExecutor(DataSource dataSource) {
        return new SqljExecutorImpl(dataSource);
    }
}
