package com.employeeregistry.task.repository;


import static com.employeeregistry.task.util.TestDataUtil.createEmployee;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.repository.impl.EmployeeRepository;
import com.employeeregistry.task.repository.impl.OrganizationRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class EmployeeJdbcTest extends AbstractJdbcTest{

  private static final Long ID = 15L;
  private static final Long ORG_ID = 20L;

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

    Employee actualEmployee = empRepository.insert(ORG_ID, employee);

    assertEquals(actualEmployee, employee);
    verify(empRepository).insert(ORG_ID, employee);
  }

  @Test
  public void existedEmployee_getEmployee_shouldReturnEmployee() {
    Employee employee = createEmployee();
    when(empRepository.findOne(ID)).thenReturn(employee);

    Employee actualEmployee = empRepository.findOne(ID);

    assertEquals(actualEmployee, employee);
    verify(empRepository).findOne(ID);
  }
}
