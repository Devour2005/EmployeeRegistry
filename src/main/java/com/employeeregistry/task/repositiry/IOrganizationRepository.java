package com.employeeregistry.task.repositiry;

import java.util.List;

public interface IOrganizationRepository<Organization> extends IRegistryRepository<Organization> {

  Organization insert(Organization org);

  List<Organization> getOrganizationsByAriaOfActivity(String aria);
}
