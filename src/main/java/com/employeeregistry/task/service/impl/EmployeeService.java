package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.repositiry.IEmployeeRepository;
import com.employeeregistry.task.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService<Employee> {

  private IEmployeeRepository<Employee> employeeRepository;

  @Autowired
  public EmployeeService(IEmployeeRepository<Employee> employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee get(Long id) {
    return this.employeeRepository.get(id);
  }

  @Override
  public Employee insert(Employee employee) {
    return this.employeeRepository.insert(employee);
  }

  @Override
  public Employee update(Long id, Employee employee) {
    return this.employeeRepository.update(id, employee);
  }

  @Override
  public void delete(Long id) {
    this.employeeRepository.delete(id);
  }

  @Override
  public List<Employee> findAll() {
    return this.employeeRepository.findAll();
  }
}
