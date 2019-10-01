package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.repositiry.IEmployeeRepository;
import com.employeeregistry.task.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService<Employee> {

  private IEmployeeRepository<Employee> repository;

  @Autowired
  public EmployeeService(IEmployeeRepository<Employee> repository) {
    this.repository = repository;
  }

  @Override
  public Employee get(Long id) {
    return this.repository.get(id);
  }

  @Override
  public int insert(Employee employee) {
    return this.repository.save(employee);
  }

  @Override
  public int update(Employee employee) {
    return this.repository.update(employee);
  }

  @Override
  public int delete(Employee employee) {
    return this.repository.delete(employee);
  }

  @Override
  public List<Employee> getAll(String sql, RowMapper rse) {
    return this.repository.getAll(sql, rse);
  }
}
