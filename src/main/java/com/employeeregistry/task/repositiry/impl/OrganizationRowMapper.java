package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.jdbc.core.RowMapper;

public class OrganizationRowMapper implements RowMapper<Organization> {

  @Override
  public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {

    Organization org = new Organization();
    org.setOrgId(rs.getLong("ORGANIZATION_ID"));
    org.setOrgName(rs.getString("ORG_NAME"));
    org.setOrgPhone(rs.getString("ORG_PHONE"));
    org.setOrgAddress(rs.getString("ORG_ADDRESS"));
    org.setRegion(Enum.valueOf(Region.class, rs.getString("ORG_REGION")));
    org.setCountry(rs.getString("ORG_COUNTRY"));
    org.setCity(rs.getString("ORG_CITY"));
    org.setIsActive(rs.getBoolean("IS_ACTIVE"));
    org.setAriaOfActivity(rs.getString("ACTIVITY_ARIA"));
    org.setNumberOfOffices(rs.getInt("OFFICES_NUMBER"));
    org.setEmployees(new ArrayList<>());

    Employee employee = new EmployeeRowMapper().mapRow(rs, 0);
    org.getEmployees().add(employee);

    return org;
  }
}
