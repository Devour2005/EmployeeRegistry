package com.employeeregistry.task.service;

import java.util.List;

public interface IEmployeeService<Employee> extends IRegistryService<Employee> {
    List<Employee> findAllByOrgId(Long id);
    void deleteAllByOrgId(Long id);
}
