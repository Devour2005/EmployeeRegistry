package com.employeeregistry.task.service;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public interface IRegistryService<T> {

  T get(Long id);

  int insert(T t);

  int update(T t);

  int delete(T t);

  List<T> getAll(String sql, RowMapper rse);
}
