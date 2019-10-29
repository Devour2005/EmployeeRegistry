package com.employeeregistry.task.repository;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.exception.ResourceNotFoundException;
import com.employeeregistry.task.repository.impl.EmployeeRepository;
import com.employeeregistry.task.repository.impl.OrganizationRepository;
import com.employeeregistry.task.service.impl.OrganizationService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class OrganizationJdbcTest extends AbstractJdbcTest {

  @InjectMocks
  private OrganizationService orgService;

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

    Organization actualOrg = orgService.insert(org);

    assertOrganization(org, actualOrg);
    verify(orgRepository).insert(org);
  }

  @Test
  public void existedOrganization_getOrganization_shouldReturnOrganization() {
    Organization org = createOrganization();
    when(orgRepository.get(ORG_ID)).thenReturn(org);

    Organization actualOrg = orgService.get(ORG_ID);

    assertOrganization(org, actualOrg);
    verify(orgRepository).get(ORG_ID);
  }

  @Test(expectedExceptions = { ResourceNotFoundException.class })
  public void notExistedOrganization_deleteOrganization_throwException() {
    when(orgRepository.get(ORG_ID)).thenReturn(null);

    orgService.delete(ORG_ID);
  }

  @Test(expectedExceptions = { ResourceNotFoundException.class })
  public void notExistedOrganization_getOrganization_throwException() {
    when(orgRepository.get(ORG_ID)).thenReturn(null);

    orgService.get(ORG_ID);
  }

  @Test
  public void validOrganization_deleteOrganization_successDeleted() {
    when(orgRepository.get(ORG_ID)).thenReturn(new Organization());
    doNothing().when(empRepository).deleteAllByOrgId(ORG_ID);
    doNothing().when(orgRepository).delete(ORG_ID);

    orgService.delete(ORG_ID);

    verify(orgRepository).get(ORG_ID);
    verify(empRepository).deleteAllByOrgId(ORG_ID);
    verify(orgRepository).delete(ORG_ID);
  }
}
