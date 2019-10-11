package com.employeeregistry.task.repositiry;

public interface IEmployeeRepository<Employee> extends IRegistryRepository<Employee>{

  Employee insert(Long id, Employee t);

  void deleteByParentId(Long id);
}
