package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.exception.ResourceNotFoundException;
import com.employeeregistry.task.repositiry.IEmployeeRepository;
import com.employeeregistry.task.service.IEmployeeService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService<Employee> {

  private IEmployeeRepository<Employee> empRepository;

  @Autowired
  public EmployeeService(IEmployeeRepository<Employee> empRepository) {
    this.empRepository = empRepository;
  }

  @Override
  public Employee get(Long id) {
    return Optional.ofNullable(empRepository.get(id))
            .orElseThrow(() -> new ResourceNotFoundException("Cannot find employee with id " + id));
  }

  @Override
  public Employee insert(Employee employee) {
    return empRepository.insert(employee);
  }

  @Override
  public Employee update(Long id, Employee employee) {
    return empRepository.update(id, employee);
  }

  @Override
  public void delete(Long id) {
    empRepository.delete(id);
  }

  @Override
  public List<Employee> findAll() {
    return empRepository.findAll();
  }

  @Override
  public List<Employee> findAllByOrgId(Long id) {
    return empRepository.findAllByOrgId(id);
  }

  @Override
  public void deleteAllByOrgId(Long id) {
    empRepository.deleteAllByOrgId(id);
  }
}
