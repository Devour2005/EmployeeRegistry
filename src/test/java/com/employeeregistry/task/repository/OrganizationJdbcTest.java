package com.employeeregistry.task.repository;


import static com.employeeregistry.task.util.TestDataUtil.ORG_ID;
import static com.employeeregistry.task.util.TestDataUtil.createOrganization;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.repository.impl.EmployeeRepository;
import com.employeeregistry.task.repository.impl.OrganizationRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class OrganizationJdbcTest extends AbstractJdbcTest {

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
  public void existedOrganization_insertOrganization_shouldReturnOrganization() {
    Organization org = createOrganization();
    when(orgRepository.insert(org)).thenReturn(org);

    Organization actualOrg = orgRepository.insert(org);

    assertEquals(actualOrg, org);
    verify(orgRepository).insert(org);
  }

  @Test
  public void existedOrganization_getOrganization_shouldReturnOrganization() {
    Organization org = createOrganization();
    when(orgRepository.findOne(ORG_ID)).thenReturn(org);

    Organization actualOrg = orgRepository.findOne(ORG_ID);

    assertEquals(actualOrg, org);
    verify(orgRepository).findOne(ORG_ID);
  }
}
