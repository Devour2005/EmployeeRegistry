package com.employeeregistry.task.service;

import java.util.List;

public interface IYearsFilter<T> {
    List<T> filterByYearsInCompany(Double years);
}
