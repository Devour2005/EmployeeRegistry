package com.employeeregistry.task.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization implements Serializable {

  private static final long serialVersionUID = 1L;

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
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Organization that = (Organization) obj;
    return Objects.equals(orgName, that.orgName) &&
        Objects.equals(orgPhone, that.orgPhone) &&
        Objects.equals(orgAddress, that.orgAddress) &&
        region == that.region &&
        Objects.equals(country, that.country) &&
        Objects.equals(city, that.city) &&
        Objects.equals(isActive, that.isActive) &&
        Objects.equals(ariaOfActivity, that.ariaOfActivity) &&
        Objects.equals(numberOfOffices, that.numberOfOffices);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(orgName, orgPhone, orgAddress, region, country, city, isActive, ariaOfActivity,
            numberOfOffices);
  }

  @Override
  public String toString() {
    return "Organization{" +
        "id='" + id + '\'' +
        ", orgName='" + orgName + '\'' +
        ", orgPhone='" + orgPhone + '\'' +
        ", orgAddress='" + orgAddress + '\'' +
        ", region=" + region +
        ", country='" + country + '\'' +
        ", city='" + city + '\'' +
        ", isActive=" + isActive +
        ", ariaOfActivity='" + ariaOfActivity + '\'' +
        ", numberOfOffices=" + numberOfOffices +
        ", employees=" + employees +
        '}';
  }
}
