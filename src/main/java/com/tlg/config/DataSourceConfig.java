package com.tlg.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataSourceConfig {

  @Value("${db.driver}")
  private String driver;

  @Value("${db.url}")
  private String url;

  @Value("${db.username}")
  private String username;

  @Value("${db.password}")
  private String password;

  @Bean
  DataSource dataSource() {
    // HikariConfig dataSourceConfig = new HikariConfig();
    // dataSourceConfig.setDriverClassName(driver);
    // dataSourceConfig.setJdbcUrl(url);
    // dataSourceConfig.setUsername(username);
    // dataSourceConfig.setPassword(password);
    // EmbeddedDatabase build = new
    // EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    // return new HikariDataSource(dataSourceConfig);
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
  }

}
