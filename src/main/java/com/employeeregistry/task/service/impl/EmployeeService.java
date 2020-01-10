package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.exception.ResourceNotFoundException;
import com.employeeregistry.task.repository.IEmployeeRepository;
import com.employeeregistry.task.service.IEmployeeService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService implements IEmployeeService<Employee> {

  private IEmployeeRepository<Employee> employeeRepository;

  @Autowired
  public EmployeeService(IEmployeeRepository<Employee> employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee findOne(Long id) {
    return Optional.ofNullable(employeeRepository.findOne(id))
        .orElseThrow(() -> new ResourceNotFoundException("Cannot find employee with id " + id));
  }

  @Override
  public Employee insert(Long id, Employee employee) {
    return this.employeeRepository.insert(id, employee);
  }

  @Override
  public Employee update(Long id, Employee employee) {
    return employeeRepository.update(id, employee);
  }

  @Override
  public void delete(Long id) {
    findOne(id);
    employeeRepository.delete(id);
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public List<Employee> findAllByOrgId(Long id) {
    return employeeRepository.findAllByOrgId(id);
  }

  @Override
  public void deleteAllByOrgId(Long id) {
    employeeRepository.deleteAllByOrgId(id);
  }

  @Override
  public List<Employee> findByPosition(String position){
    return employeeRepository.findByPosition(position);
  }

  @Override
  public List<Employee> filterByYearsInCompany(Double years) {
    return employeeRepository.findAll().stream()
            .filter(e -> e.getYearsInCompany().equals(years))
            .collect(Collectors.toList());
  }
}
