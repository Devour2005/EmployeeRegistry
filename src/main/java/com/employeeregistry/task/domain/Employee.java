package com.employeeregistry.task.domain;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long employeeId;
  private Long orgId;
  private String firstName;
  private String lastName;
  private String empPosition;
  private Boolean isMarried;
  private Double yearsInCompany;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Employee employee = (Employee) obj;
    return Objects.equals(firstName, employee.firstName) &&
        Objects.equals(orgId, employee.orgId) &&
        Objects.equals(lastName, employee.lastName) &&
        Objects.equals(empPosition, employee.empPosition) &&
        Objects.equals(isMarried, employee.isMarried) &&
        Objects.equals(yearsInCompany, employee.yearsInCompany);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orgId, firstName, lastName, empPosition, isMarried, yearsInCompany);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "firstName='" + firstName + '\'' +
        ", secondName='" + lastName + '\'' +
        ", position='" + empPosition + '\'' +
        ", isMarried=" + isMarried +
        ", yearsInCompany=" + yearsInCompany +
        '}';
  }
}
