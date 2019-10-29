package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OrganizationRowMapper implements RowMapper<Organization> {

  @Override
  public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
    Organization organization = new Organization();
    organization.setId(rs.getLong("id"));
    organization.setOrgName(rs.getString("org_name"));
    organization.setOrgPhone(rs.getString("org_phone"));
    organization.setOrgAddress(rs.getString("org_address"));
    organization.setCountry(rs.getString("country"));
    organization.setCity(rs.getString("city"));
    organization.setIsActive(rs.getBoolean("is_active"));
    organization.setAriaOfActivity(rs.getString("aria_of_activity"));
    organization.setNumberOfOffices(rs.getInt("number_of_offices"));
    organization.setRegion(Enum.valueOf(Region.class, rs.getString("region")));
    return organization;
  }
}
