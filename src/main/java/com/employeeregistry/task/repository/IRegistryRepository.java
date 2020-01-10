package com.employeeregistry.task.repository;

import java.util.List;

public interface IRegistryRepository<T> {

  T findOne(Long id);

  T update(Long id, T t);

  void delete(Long id);

  List<T> findAll();
}
