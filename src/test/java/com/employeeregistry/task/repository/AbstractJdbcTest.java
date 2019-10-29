package com.employeeregistry.task.repository;


import static org.testng.Assert.assertEquals;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import java.util.Collections;

public class AbstractJdbcTest {

  protected static final Long ID = 15L;
  protected static final Long ORG_ID = 20L;

  void assertOrganization(Organization org, Organization actualOrg) {
    assertEquals(actualOrg.getId(), org.getId());
    assertEquals(actualOrg.getOrgName(), org.getOrgName());
    assertEquals(actualOrg.getOrgPhone(), org.getOrgPhone());
    assertEquals(actualOrg.getOrgAddress(), org.getOrgAddress());
    assertEquals(actualOrg.getRegion(), org.getRegion());
    assertEquals(actualOrg.getCountry(), org.getCountry());
    assertEquals(actualOrg.getCity(), org.getCity());
    assertEquals(actualOrg.getIsActive(), org.getIsActive());
    assertEquals(actualOrg.getAriaOfActivity(), org.getAriaOfActivity());
    assertEquals(actualOrg.getNumberOfOffices(), org.getNumberOfOffices());
    assertEquals(actualOrg.getEmployees(), org.getEmployees());
  }

  void assertEmployee(Employee employee, Employee actualEmployee) {
    assertEquals(actualEmployee.getOrgId(), employee.getOrgId());
    assertEquals(actualEmployee.getFirstName(), employee.getFirstName());
    assertEquals(actualEmployee.getLastName(), employee.getLastName());
    assertEquals(actualEmployee.getEmpPosition(), employee.getEmpPosition());
    assertEquals(actualEmployee.getIsMarried(), employee.getIsMarried());
    assertEquals(actualEmployee.getYearsInCompany(), employee.getYearsInCompany());
  }

  protected Organization createOrganization() {
    Organization org = new Organization();
    org.setId(ORG_ID);
    org.setOrgName("OrgName");
    org.setOrgPhone("OrgPhone");
    org.setOrgAddress("OrgAddress");
    org.setRegion(Region.AMERICA);
    org.setCountry("Ukraine");
    org.setCity("Kharkov");
    org.setIsActive(true);
    org.setAriaOfActivity("IT");
    org.setNumberOfOffices(3);
    org.setEmployees(Collections.singletonList(createEmployee()));
    return org;
  }

  protected Employee createEmployee() {
    Employee emp = new Employee();
    emp.setId(ID);
    emp.setOrgId(ORG_ID);
    emp.setFirstName("FirstName");
    emp.setLastName("LastName");
    emp.setEmpPosition("Position");
    emp.setIsMarried(true);
    emp.setYearsInCompany(3.0);
    return emp;
  }

}
