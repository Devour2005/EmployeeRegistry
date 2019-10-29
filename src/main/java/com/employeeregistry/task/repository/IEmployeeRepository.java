package com.employeeregistry.task.repository;

import java.util.List;

public interface IEmployeeRepository<Employee> extends IRegistryRepository<Employee>{

  Employee insert(Long id, Employee e);

  List<Employee> findAllByOrgId(Long id);

  void deleteAllByOrgId(Long id);

  List<Employee> findByPosition(String position);
}
