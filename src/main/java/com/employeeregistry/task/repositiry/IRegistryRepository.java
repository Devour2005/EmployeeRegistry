package com.employeeregistry.task.repositiry;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public interface IRegistryRepository<T> {

  T get(Long id);

  int save(T t);

  int update(T t);

  int delete(T t);

  List<T> getAll(String sql, RowMapper rse);
}
