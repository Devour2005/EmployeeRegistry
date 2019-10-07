package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.repositiry.IEmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository implements IEmployeeRepository<Employee> {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public EmployeeRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Employee get(Long id) {
    String sql = "SELECT * FROM employee WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
  }

  @Override
  public int save(Employee e) {
    String query =
        "INSERT INTO employee VALUES('" + e.getFirstName() + "','"
            + e.getLastName() + e.getEmpPosition() + "','"
            + e.getIsMarried() + "','" + e.getYearsInCompany() + "')";
    return jdbcTemplate.update(query);
  }

  @Override
  public int update(Employee e) {
    String query = "UPDATE employee SET org_id='" + e.getOrgId()
            + ", 'first_name= + '" + e.getFirstName() + "',last_name='"
        + e.getLastName() + "', emp_position='" + e.getEmpPosition() + "',is_married='" + e.getIsMarried()
        + "' WHERE id='" + e.getEmployeeId() + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public int delete(Employee e) {
    String query = "DELETE FROM employee WHERE id='" + e.getEmployeeId() + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public List<Employee> getAll(String sql, RowMapper rse) {
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
}
