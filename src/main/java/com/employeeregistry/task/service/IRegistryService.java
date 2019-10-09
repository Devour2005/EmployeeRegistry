package com.employeeregistry.task.service;

import java.util.List;

public interface IRegistryService<T> {

  T get(Long id);

  T insert(T t);

  T update(Long id, T t);

  void delete(Long id);

  List<T> findAll();
}
