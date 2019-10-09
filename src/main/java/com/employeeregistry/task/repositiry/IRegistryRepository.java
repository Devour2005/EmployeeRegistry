package com.employeeregistry.task.repositiry;

import java.util.List;

public interface IRegistryRepository<T> {

  T get(Long id);

  T insert(T t);

  T update(Long id, T t);

  void delete(Long id);

  List<T> findAll();
}
