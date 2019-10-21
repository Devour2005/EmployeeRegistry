package com.employeeregistry.task.repositiry.impl;

import com.employeeregistry.task.domain.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

    Employee employee = new Employee();
    employee.setId(rs.getLong("id"));
    employee.setOrgId(rs.getLong("org_id"));
    employee.setFirstName(rs.getString("first_name"));
    employee.setLastName(rs.getString("last_name"));
    employee.setEmpPosition(rs.getString("emp_position"));
    employee.setIsMarried(rs.getBoolean("is_married"));
    employee.setYearsInCompany(rs.getDouble("years_in_company"));
    return employee;
  }
}
