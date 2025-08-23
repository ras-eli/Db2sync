package de.syncdb2.starter;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;
import de.syncdb2.core.SqljExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Testet die Auto-Konfiguration.
 */
class SyncDb2AutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withBean(DataSource.class, () -> new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build())
            .withConfiguration(AutoConfigurations.of(SyncDb2AutoConfiguration.class));

    @Test
    void erstelltExecutor() {
        contextRunner.run(context -> assertThat(context).hasSingleBean(SqljExecutor.class));
    }
}
