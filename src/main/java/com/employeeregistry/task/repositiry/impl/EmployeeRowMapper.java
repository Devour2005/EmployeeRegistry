package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

    Employee employee = new Employee();
    employee.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
    employee.setFirstName(rs.getString("FIRST_NAME"));
    employee.setLastName(rs.getString("LAST_NAME"));
    employee.setPosition(rs.getString("POSITION"));
    employee.setIsMarried(rs.getBoolean("IS_MARRIED"));
    employee.setYearsInCompany(rs.getDouble("YEARS_IN_COMPANY"));
    return employee;
  }
}
