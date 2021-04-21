package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.exception.ResourceNotFoundException;
import com.employeeregistry.task.repository.IEmployeeRepository;
import com.employeeregistry.task.repository.IOrganizationRepository;
import com.employeeregistry.task.service.IOrganizationService;
import com.employeeregistry.task.service.IProfessionFilter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfessionService implements IOrganizationService<Organization>,
    IProfessionFilter {

  private IOrganizationRepository<Organization> orgRepository;
  private IEmployeeRepository<Employee> empRepository;

  @Autowired
  public ProfessionService(IOrganizationRepository<Organization> orgRepository,
      IEmployeeRepository<Employee> empRepository) {
    this.orgRepository = orgRepository;
    this.empRepository = empRepository;
  }

  @Override
  public Organization findOne(Long id) {
    return Optional.ofNullable(orgRepository.findOne(id))
        .orElseThrow(() -> new ResourceNotFoundException("Cannot find organization with id " + id));
  }

  @Override
  public Organization insert(Organization organization) {
    return orgRepository.insert(organization);
  }

  @Override
  public List<Organization> findOrganizationsByAriaOfActivity(String aria) {
    return orgRepository.findOrganizationsByAriaOfActivity(aria);
  }

  @Override
  public Organization update(Long id, Organization organization) {
    return orgRepository.update(id, organization);
  }

  @Override
  public void delete(Long id) {
    findOne(id);
    empRepository.deleteAllByOrgId(id);
    orgRepository.delete(id);
  }

  @Override
  public List<Organization> findAll() {
    return orgRepository.findAll().stream()
        .peek(o -> o.setEmployees(empRepository.findAllByOrgId(o.getId())))
        .collect(Collectors.toList());
  }

  @Override
  public List<String> findCountriesOfOrgsWithDoctorsInEurope(String region, Integer numberOfSpecialists) {
    return orgRepository.findCountriesOfOrgsWithDoctorsInEurope(region, numberOfSpecialists);
  }
}
