package com.employeeregistry.task.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class SpringJdbcConfig {

  @Autowired
  JdbcProperties jdbcProperties;

  @Bean
  public DataSource mysqlDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
    dataSource.setUrl(jdbcProperties.getUrl());
    dataSource.setUsername(jdbcProperties.getUserName());
    dataSource.setPassword(jdbcProperties.getPassword());

    return dataSource;
  }
}
