package com.employeeregistry.task.repository.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.repository.AbstractRepository;
import com.employeeregistry.task.repository.IEmployeeRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository extends AbstractRepository implements IEmployeeRepository<Employee> {

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Employee findOne(Long id) {
        try {
            return jdbcTemplate
                .queryForObject("SELECT * FROM employee WHERE id = ?", new Object[] {id},
                    new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Employee insert(Long id, Employee e) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query =
            "INSERT INTO employee(org_id, first_name, last_name, emp_position, is_married, years_in_company) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, new String[] { "id"});
            ps.setLong(1, id);
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getEmpPosition());
            ps.setBoolean(5, e.getIsMarried());
            ps.setDouble(6, e.getYearsInCompany());
            return ps;
        }, keyHolder);

        Long empId;
        if (keyHolder.getKeys().size() > 1) {
            empId = (Long)keyHolder.getKeys().get("id");
        } else {
            empId= keyHolder.getKey().longValue();
        }
        return findOne(empId);
    }

    @Override
    public Employee update(Long id, Employee e) {
        jdbcTemplate.update(
            "UPDATE employee SET org_id = ?, first_name = ?, last_name = ?, emp_position = ?, is_married = ?, years_in_company = ? WHERE id = ?",
                e.getOrgId(), e.getFirstName(), e.getLastName(), e.getEmpPosition(), e.getIsMarried(), e.getYearsInCompany(), id);
        return findOne(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }

    @Override
    public List<Employee> findAll() {
      return jdbcTemplate.query("SELECT * FROM employee", this::mapEmployees);
    }

    @Override
    public void deleteAllByOrgId(Long orgId) {
        jdbcTemplate.update("DELETE FROM employee WHERE org_id = ?", orgId);
    }

    @Override
    public List<Employee> findAllByOrgId(Long orgId) {
        return jdbcTemplate.query("SELECT * FROM employee WHERE org_id = ?", new Object[]{orgId},
            this::mapEmployees);
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return jdbcTemplate
            .query("SELECT * FROM employee WHERE emp_position = ?", new Object[]{position},
                this::mapEmployees);

    }

  private List<Employee> mapEmployees(ResultSet rs) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setOrgId(rs.getLong("org_id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmpPosition(rs.getString("emp_position"));
            employee.setIsMarried(rs.getBoolean("is_married"));
            employee.setYearsInCompany(rs.getDouble("years_in_company"));
            employees.add(employee);
        }
        return employees;
    }
}
