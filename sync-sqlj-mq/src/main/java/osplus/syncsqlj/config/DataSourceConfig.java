package osplus.syncsqlj.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Konfiguration der zwei HikariCP DataSources.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.primary")
    public DataSourceProperties primaryProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSourceProperties secondaryProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "primaryDataSource")
    public DataSource primaryDataSource(DataSourceProperties primaryProperties) {
        return primaryProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource(DataSourceProperties secondaryProperties) {
        return secondaryProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}
