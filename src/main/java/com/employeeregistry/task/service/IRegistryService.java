package com.employeeregistry.task.service;

import java.util.List;

public interface IRegistryService<T> {

  T get(Long id);

  int insert(T t);

  int update(Long id, T t);

  int delete(Long id);

  List<T> getAll();
}
