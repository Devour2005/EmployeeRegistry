package com.employeeregistry.task.repositiry;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractRepository {

  protected JdbcTemplate jdbcTemplate;

  public AbstractRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
