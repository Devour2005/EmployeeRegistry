package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import com.employeeregistry.task.repositiry.IOrganizationRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository implements IOrganizationRepository<Organization> {

  private JdbcTemplate jdbcTemplate;


  public OrganizationRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Organization get(Long id) {
    String sql = "select * from organization where id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrganizationRowMapper());
  }

  @Override
  public int save(Organization org) {
    String query =
        "insert into organization values('" + org.getOrgName() + "','"
            + org.getOrgPhone() + "','" + org.getOrgAddress() + "','"
            + org.getRegion() + "','" + org.getCountry()+ "','"
            + org.getCity() + "','" + org.getIsActive() + "','"
            + org.getAriaOfActivity() + "','" + org.getEmployees() + "')";
    return jdbcTemplate.update(query);
  }

  @Override
  public int update(Organization org) {
    String query = "update organization set orgName='" + org.getOrgName() + "', orgPhone='"
        + org.getOrgPhone() + "', orgAddress='" + org.getOrgAddress() + "',region='" + org.getRegion()
        + "',country='" + org.getCountry() + "', city='" + org.getCity() + "',isActive='" + org.getIsActive()
        + "',ariaOfActivity='" + org.getAriaOfActivity() + "', numberOfOffices='" + org.getNumberOfOffices()
        + "',employees='" + org.getEmployees()
        + "' where id='" + org.getOrgId() + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public int delete(Organization org) {
    String query = "delete from organization where id='" + org.getOrgId() + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public List<Organization> getAll(String sql, RowMapper rse) {
    return jdbcTemplate.query("select * from organization", rs -> {

      List<Organization> orgs = new ArrayList<>();
      while (rs.next()) {
        Organization organization = new Organization();
        organization.setOrgId(rs.getLong("ID"));
        organization.setOrgName(rs.getString("ORG_NAME"));
        organization.setOrgPhone(rs.getString("ORG_PHONE"));
        organization.setOrgAddress(rs.getString("ORG_ADDRESS"));
        organization.setRegion(Enum.valueOf(Region.class, rs.getString("ORG_REGION")));
        organization.setCountry(rs.getString("ORG_COUNTRY"));
        organization.setCity(rs.getString("ORG_CITY"));
        organization.setIsActive(rs.getBoolean("IS_ACTIVE"));
        organization.setAriaOfActivity(rs.getString("ACTIVITY_ARIA"));
        organization.setNumberOfOffices(rs.getInt("OFFICES_NUMBER"));
        organization.setEmployees(new ArrayList<>());

        Employee employee = new EmployeeRowMapper().mapRow(rs, 0);
        organization.getEmployees().add(employee);
        orgs.add(organization);
      }
      return orgs;
    });
  }
}
