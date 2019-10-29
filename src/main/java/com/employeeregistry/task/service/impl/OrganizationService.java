package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.exception.ResourceNotFoundException;
import com.employeeregistry.task.repository.IEmployeeRepository;
import com.employeeregistry.task.repository.IOrganizationRepository;
import com.employeeregistry.task.service.IOrganizationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
    return Optional.ofNullable(orgRepository.get(id))
        .orElseThrow(() -> new ResourceNotFoundException("Cannot find organization with id " + id));
  }

  @Override
  public Organization insert(Organization organization) {
    return orgRepository.insert(organization);
  }

  @Override
  public List<Organization> getOrganizationsByAriaOfActivity(String aria) {
    return orgRepository.getOrganizationsByAriaOfActivity(aria);
  }

  @Override
  public Organization update(Long id, Organization organization) {
    return orgRepository.update(id, organization);
  }

  @Override
  public void delete(Long id) {
    get(id);
    empRepository.deleteAllByOrgId(id);
    orgRepository.delete(id);
  }

  @Override
  public List<Organization> findAll() {
    List<Organization> orgs = orgRepository.findAll();
    for (Organization org : orgs) {
      org.setEmployees(empRepository.findAllByOrgId(org.getId()));
    }
    return orgs;
  }
}
