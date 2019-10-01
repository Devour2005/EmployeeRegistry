package com.employeeregistry.task.service.impl;

import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.repositiry.IOrganizationRepository;
import com.employeeregistry.task.service.IOrganizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IOrganizationService<Organization> {

  private IOrganizationRepository<Organization> repository;

  @Autowired
  public OrganizationService(IOrganizationRepository<Organization> repository) {
    this.repository = repository;
  }

  @Override
  public Organization get(Long id) {
    return this.repository.get(id);
  }

  @Override
  public int insert(Organization organization) {
    return this.repository.save(organization);
  }

  @Override
  public int update(Organization organization) {
    return this.repository.update(organization);
  }

  @Override
  public int delete(Organization organization) {
    return this.repository.delete(organization);
  }

  @Override
  public List<Organization> getAll(String sql, RowMapper rse) {
    return this.repository.getAll(sql, rse);
  }
}
