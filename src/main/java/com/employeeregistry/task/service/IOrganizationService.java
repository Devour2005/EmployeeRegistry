package com.employeeregistry.task.service;

import java.util.List;

public interface IOrganizationService<Organization> extends IRegistryService<Organization>{

  Organization insert(Organization org);

  List<Organization> findOrganizationsByAriaOfActivity(String aria);
}
