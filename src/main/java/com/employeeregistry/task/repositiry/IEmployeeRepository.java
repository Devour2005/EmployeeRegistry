package com.employeeregistry.task.repositiry;

import java.util.List;

public interface IEmployeeRepository<Employee> extends IRegistryRepository<Employee>{
    List<Employee> findAllByOrgId(Long id);
    void deleteAllByOrgId(Long id);
}
