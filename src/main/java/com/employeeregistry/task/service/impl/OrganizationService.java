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
  public OrganizationService(IOrganizationRepository<Organization> orgRepository,
                             IEmployeeRepository<Employee> empRepository) {
    this.orgRepository = orgRepository;
    this.empRepository = empRepository;
  }

  @Override
  public Organization get(Long id) {
    return orgRepository.get(id);
  }

  @Override
  public Organization insert(Organization organization) {
    return orgRepository.insert(organization);
  }

  @Override
  public Organization update(Long id, Organization organization) {
    return orgRepository.update(id, organization);
  }

  @Override
  public void delete(Long id) {
    empRepository.deleteByParentId(id);
    orgRepository.delete(id);
  }

  @Override
  public List<Organization> findAll() {
    return orgRepository.findAll();
  }
}
