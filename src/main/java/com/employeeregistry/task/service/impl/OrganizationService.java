package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.repositiry.IEmployeeRepository;
import com.employeeregistry.task.repositiry.IOrganizationRepository;
import com.employeeregistry.task.service.IOrganizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IOrganizationService<Organization> {

  private IOrganizationRepository<Organization> orgRepository;
  private IEmployeeRepository<Employee> empRepository;

  @Autowired
  public OrganizationService(IOrganizationRepository<Organization> orgRepository) {
    this.orgRepository = orgRepository;
  }

  @Override
  public Organization get(Long id) {
    return this.orgRepository.get(id);
  }

  @Override
  public int insert(Organization organization) {
    return this.orgRepository.save(organization);
  }

  @Override
  public int update(Long id, Organization organization) {
    return this.orgRepository.update(id, organization);
  }

  @Override
  public int delete(Long id) {
    return this.orgRepository.delete(id);
  }

  @Override
  public List<Organization> getAll() {
    return this.orgRepository.getAll();
  }
}
