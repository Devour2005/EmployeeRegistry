package com.employeeregistry.task.service;

public interface IOrganizationService<Organization> extends IRegistryService<Organization>{
    Organization insert(Organization org);
}
