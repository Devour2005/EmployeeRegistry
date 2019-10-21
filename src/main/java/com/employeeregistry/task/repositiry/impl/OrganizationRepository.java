package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.domain.Region;
import com.employeeregistry.task.repositiry.IOrganizationRepository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository implements IOrganizationRepository<Organization> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrganizationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Organization get(Long id) {
        String sql = "SELECT * FROM organization WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrganizationRowMapper());
    }

    @Override
    public Organization insert(Organization org) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO organization(org_name, org_phone, org_address, region, country, city, is_active, " +
                "aria_of_activity, number_of_offices) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ps.setString(1, org.getOrgName());
            ps.setString(2, org.getOrgPhone());
            ps.setString(3, org.getOrgAddress());
            ps.setObject(4, org.getRegion());
            ps.setString(5, org.getCountry());
            ps.setString(6, org.getCity());
            ps.setBoolean(7, org.getIsActive());
            ps.setString(8, org.getAriaOfActivity());
            ps.setInt(9, org.getNumberOfOffices());
            return ps;
        }, keyHolder);
        long orgId = keyHolder.getKey().longValue();
        return get(orgId);
    }

    @Override
    public Organization update(Long id, Organization org) {
        jdbcTemplate.update("UPDATE organization SET org_name = ?, org_phone = ?, org_address = ?, region = ?," +
                        "country = ?, city = ?, is_active = ?, aria_of_activity = ?, number_of_offices = ? WHERE id = ?",
                org.getOrgName(), org.getOrgPhone(), org.getOrgAddress(), org.getRegion(), org.getCountry(),
                org.getCity(), org.getIsActive(), org.getAriaOfActivity(), org.getNumberOfOffices(), id);
        return get(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM organization WHERE id = ?", id);
    }

    @Override
    public List<Organization> findAll() {
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
