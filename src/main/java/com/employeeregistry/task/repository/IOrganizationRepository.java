package com.employeeregistry.task.repository;

import com.employeeregistry.task.service.IProffessionFilter;
import java.util.List;

public interface IOrganizationRepository<Organization> extends IRegistryRepository<Organization>,
    IProffessionFilter {

  Organization insert(Organization org);

  List<Organization> getOrganizationsByAriaOfActivity(String aria);
}
