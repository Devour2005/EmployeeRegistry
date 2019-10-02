package com.employeeregistry.task.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization implements Serializable {

  private Long id;
  private String orgName;
  private String orgPhone;
  private String orgAddress;
  private Region region;
  private String country;
  private String city;
  private Boolean isActive;
  private String ariaOfActivity;
  private Integer numberOfOffices;
  private List<Employee> employees = new ArrayList<>();

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
