package com.employeeregistry.task.repository;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

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

@Test
public class EmployeeJdbcTest extends AbstractJdbcTest{

  private static final Long ID = 15L;
  private static final Long ORG_ID = 20L;

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
  @Test
  public void existedEmployee_insertEmployee_shouldReturnEmployee() {
    Employee employee = createEmployee();
    when(empRepository.insert(ORG_ID, employee)).thenReturn(employee);

    Employee actualEmployee = empService.insert(ORG_ID, employee);

    assertEquals(actualEmployee, employee);
    verify(empRepository).insert(ORG_ID, employee);
  }

  @Test
  public void existedEmployee_getEmployee_shouldReturnEmployee() {
    Employee employee = createEmployee();
    when(empRepository.get(ID)).thenReturn(employee);

    Employee actualEmployee = empService.get(ID);

    assertEquals(actualEmployee, employee);
    verify(empRepository).get(ID);
  }

  @Test(expectedExceptions = { ResourceNotFoundException.class })
  public void notExistedEmployee_deleteEmployee_throwException() {
    when(empRepository.get(ID)).thenReturn(null);

    empService.delete(ID);
  }

  @Test(expectedExceptions = { ResourceNotFoundException.class })
  public void notExistedEmployee_getEmployee_throwException() {
    when(empRepository.get(ID)).thenReturn(null);

    empService.get(ID);
  }

  @Test
  public void validEmployee_deleteEmployee_successDeleted() {
    when(empRepository.get(ID)).thenReturn(new Employee());
    doNothing().when(empRepository).delete(ID);

    empService.delete(ID);

    verify(empRepository).get(ID);
    verify(empRepository).delete(ID);
  }
}
