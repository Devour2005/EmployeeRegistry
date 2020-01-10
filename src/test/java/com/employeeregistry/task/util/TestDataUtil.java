package com.employeeregistry.task.util;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import java.util.Collections;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataUtil {

  public static final Long ID = 15L;
  public static final Long ORG_ID = 20L;

  public static Organization createOrganization() {
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

  public static Employee createEmployee() {
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
