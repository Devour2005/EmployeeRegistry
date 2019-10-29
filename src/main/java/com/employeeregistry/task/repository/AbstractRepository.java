package com.employeeregistry.task.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractRepository {

  protected JdbcTemplate jdbcTemplate;

  public AbstractRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
