package com.employeeregistry.task.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix="spring.datasource")
public class JdbcProperties {

  private String driverClassName;
  private String url;
  private String userName;
  private String password;

}
