package com.employeeregistry.task.repository;

import com.employeeregistry.task.service.IProfessionFilter;
import java.util.List;

public interface IOrganizationRepository<Organization> extends IRegistryRepository<Organization>,
    IProfessionFilter {

  Organization insert(Organization org);

  List<Organization> findOrganizationsByAriaOfActivity(String aria);
}
