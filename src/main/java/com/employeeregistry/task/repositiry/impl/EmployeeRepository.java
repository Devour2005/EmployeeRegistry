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
    String sql = "select * from employee where id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
  }

  @Override
  public int save(Employee e) {
    String query =
        "insert into employee values('" + e.getFirstName() + "','"
            + e.getLastName() + e.getPosition() + "','"
            + e.getIsMarried() + "','" + e.getYearsInCompany() + "')";
    return jdbcTemplate.update(query);
  }

  @Override
  public int update(Employee e) {
    String query = "update employee set fisrtName='" + e.getFirstName() + "',secondName='"
        + e.getLastName() + "', position='" + e.getPosition() + "',isMarried='" + e.getIsMarried()
        + "' where id='" + e.getEmployeeId() + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public int delete(Employee e) {
    String query = "delete from employee where id='" + e.getEmployeeId() + "' ";
    return jdbcTemplate.update(query);
  }

  @Override
  public List<Employee> getAll(String sql, RowMapper rse) {
    return jdbcTemplate.query("select * from employee", rs -> {

      List<Employee> employees = new ArrayList<>();
      while (rs.next()) {
        Employee emp = new Employee();
        emp.setEmployeeId(rs.getLong("ID"));
        emp.setFirstName(rs.getString("FIRST_NAME"));
        emp.setLastName(rs.getString("LAST_NAME"));
        emp.setPosition(rs.getString("POSITION"));
        emp.setIsMarried(rs.getBoolean("IS_MARRIED"));
        emp.setYearsInCompany(rs.getDouble("YEARS_IN_COMPANY"));
        employees.add(emp);
      }
      return employees;
    });
  }
}
