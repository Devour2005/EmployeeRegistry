package com.employeeregistry.task.service;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.exception.ResourceNotFoundException;
import com.employeeregistry.task.repository.impl.EmployeeRepository;
import com.employeeregistry.task.repository.impl.OrganizationRepository;
import com.employeeregistry.task.service.impl.EmployeeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeServiceTest {

  private static final Long ID = 15L;

  @InjectMocks
  private EmployeeService empService;

  @Mock
  private OrganizationRepository orgRepository;

  @Mock
  private EmployeeRepository empRepository;

  @BeforeClass
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @BeforeMethod
  public void beforeMethod() {
    reset(orgRepository);
    reset(empRepository);
  }

  // <given>_<action>_<expectedResult>
  @Test(expectedExceptions = {ResourceNotFoundException.class})
  public void notExistedEmployee_findEmployee_throwException() {
    when(empRepository.findOne(ID)).thenReturn(null);

    empService.findOne(ID);
  }

  @Test
  public void validEmployee_deleteEmployee_successDeleted() {
    when(empRepository.findOne(ID)).thenReturn(new Employee());
    doNothing().when(empRepository).delete(ID);

    empService.delete(ID);

    verify(empRepository).findOne(ID);
    verify(empRepository).delete(ID);
  }
}
