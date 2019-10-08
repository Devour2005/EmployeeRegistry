package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import com.employeeregistry.task.repositiry.IOrganizationRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository implements IOrganizationRepository<Organization> {

  private JdbcTemplate jdbcTemplate;


  public OrganizationRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Organization get(Long id) {
    String sql = "SELECT * FROM organization WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrganizationRowMapper());
  }

  @Override
  public int save(Organization org) {
    String query =
        "INSERT INTO organization VALUES('" + org.getOrgName() + "','"
            + org.getOrgPhone() + "','" + org.getOrgAddress() + "','"
            + org.getCountry()+ "','" + org.getCity() + "','"
            + org.getIsActive() + "','" + org.getAriaOfActivity() + "','"
            + org.getRegion()  + "','" + org.getEmployees() + "')";
    return jdbcTemplate.update(query);
  }

  @Override
  public int update(Long id, Organization org) {
    String query = "UPDATE organization SET org_name='" + org.getOrgName() + "', org_phone='"
        + org.getOrgPhone() + "', org_address='" + org.getOrgAddress()
        + "', country='" + org.getCountry() + "', city='" + org.getCity() + "', is_active='" + org.getIsActive()
        + "', aria_of_activity='" + org.getAriaOfActivity() + "', number_of_offices='" + org.getNumberOfOffices()
        + "', region='" + org.getRegion()
        + "', employees='" + org.getEmployees()
        + "' WHERE id='" + id + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public int delete(Long id) {
    String query = "DELETE FROM organization WHERE id='" + id + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public List<Organization> getAll() {
    return jdbcTemplate.query("SELECT * FROM organization", rs -> {

      List<Organization> orgs = new ArrayList<>();
      while (rs.next()) {
        Organization organization = new Organization();
        organization.setOrgName(rs.getString("org_name"));
        organization.setOrgPhone(rs.getString("org_phone"));
        organization.setOrgAddress(rs.getString("org_address"));
        organization.setCountry(rs.getString("country"));
        organization.setCity(rs.getString("city"));
        organization.setIsActive(rs.getBoolean("is_active"));
        organization.setAriaOfActivity(rs.getString("aria_of_activity"));
        organization.setNumberOfOffices(rs.getInt("number_of_offices"));
        organization.setRegion(Enum.valueOf(Region.class, rs.getString("region")));
        organization.setEmployees(new ArrayList<>());

        Employee employee = new EmployeeRowMapper().mapRow(rs, 0);
        organization.getEmployees().add(employee);
        orgs.add(organization);
      }
      return orgs;
    });
  }
}
