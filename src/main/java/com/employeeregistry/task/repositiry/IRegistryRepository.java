package com.employeeregistry.task.repositiry;

import java.util.List;

public interface IRegistryRepository<T> {

  T get(Long id);

  int save(T t);

  int update(Long id, T t);

  int delete(Long id);

  List<T> getAll();
}
