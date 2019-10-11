package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.repositiry.AbstractRepository;
import com.employeeregistry.task.repositiry.IEmployeeRepository;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository extends AbstractRepository implements IEmployeeRepository<Employee> {

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Employee get(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?", new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public Employee insert(Long id, Employee e) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO employee(org_id, org_id, last_name, emp_position, is_married, years_in_company) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ps.setLong(1, e.getOrgId());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getEmpPosition());
            ps.setBoolean(5, e.getIsMarried());
            ps.setDouble(6, e.getYearsInCompany());
            return ps;
        });
        long empId = keyHolder.getKey().longValue();
        return get(empId);
    }

    @Override
    public Employee update(Long id, Employee e) {
        jdbcTemplate.update("UPDATE employee SET org_id = ?,first_name = ?, last_name = ?, emp_position = ?, is_married = ? WHERE id = ?",
                e.getFirstName(), e.getLastName(), e.getEmpPosition(), e.getIsMarried(), e.getYearsInCompany(), id);
        return get(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", rs -> {

            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getLong("id"));
                employee.setOrgId(rs.getLong("org_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmpPosition(rs.getString("emp_position"));
                employee.setIsMarried(rs.getBoolean("is_married"));
                employee.setYearsInCompany(rs.getDouble("years_in_company"));
                employees.add(employee);
            }
            return employees;
        });
    }

    @Override
    public void deleteByParentId(Long id) {

    }
}
