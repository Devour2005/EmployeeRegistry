package com.employeeregistry.task.service;

import java.util.List;

public interface IProfessionFilter {

  List<String> findCountriesOfOrgsWithDoctorsInEurope(String region, Integer numberOfSpecialists);
}
