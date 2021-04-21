package com.employeeregistry.task.domain;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Long orgId;
  private String firstName;
  private String lastName;
  private String empPosition;
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
    return Objects.equals(orgId, employee.orgId) &&
        Objects.equals(firstName, employee.firstName) &&
        Objects.equals(lastName, employee.lastName) &&
        Objects.equals(empPosition, employee.empPosition) &&
        Objects.equals(isMarried, employee.isMarried) &&
        Objects.equals(yearsInCompany, employee.yearsInCompany);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orgId, firstName, lastName, empPosition, isMarried, yearsInCompany);
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", orgId=" + orgId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", empPosition='" + empPosition + '\'' +
            ", isMarried=" + isMarried +
            ", yearsInCompany=" + yearsInCompany +
            '}';
  }
}
