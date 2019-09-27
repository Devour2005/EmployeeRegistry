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
  private String firstName;
  private String lastName;
  private String position;
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
        Objects.equals(lastName, employee.lastName) &&
        Objects.equals(position, employee.position) &&
        Objects.equals(isMarried, employee.isMarried) &&
        Objects.equals(yearsInCompany, employee.yearsInCompany);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, position, isMarried, yearsInCompany);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", position='" + position + '\'' +
        ", isMarried=" + isMarried +
        ", yearsInCompany=" + yearsInCompany +
        '}';
  }
}
