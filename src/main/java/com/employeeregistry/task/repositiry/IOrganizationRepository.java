package com.employeeregistry.task.repositiry;

public interface IOrganizationRepository<Organization> extends IRegistryRepository<Organization> {

  Organization insert(Organization t);
}
