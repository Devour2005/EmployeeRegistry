package com.employeeregistry.task.service;


import java.util.List;

public interface IEmployeeService<Employee> extends IRegistryService<Employee> {
    Employee insert(Long id, Employee employee);

    List<Employee> findAllByOrgId(Long id);

    void deleteAllByOrgId(Long id);
}
