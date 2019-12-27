package com.employeeregistry.task.service;

import java.util.List;

public interface IProffessionFilter {

  List<String> getCountriesOfOrgsWithDoctorsInEurope(String region, Integer numberOfSpecialists);
}
