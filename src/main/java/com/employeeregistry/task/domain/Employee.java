package com.employeeregistry.task.domain;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee implements Serializable {

  private Long employeeId;
  private String firstName;
  private String secondName;
  private String position;
  private Boolean isMarried;
  private Double yearsInCompany;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(firstName, employee.firstName) &&
        Objects.equals(secondName, employee.secondName) &&
        Objects.equals(position, employee.position) &&
        Objects.equals(isMarried, employee.isMarried) &&
        Objects.equals(yearsInCompany, employee.yearsInCompany);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, secondName, position, isMarried, yearsInCompany);
  }

  @Override
  public String toString() {
    return null;
  }
}
