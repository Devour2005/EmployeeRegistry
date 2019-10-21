package com.employeeregistry.task.controller;

import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/organization", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {

    private IOrganizationService<Organization> orgService;

    @Autowired
    public OrganizationController(IOrganizationService<Organization> orgService) {
        this.orgService = orgService;
    }

    @PostMapping
//  @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Organization createOrganization(@RequestBody Organization organization) {
        return orgService.insert(organization);
    }

    @GetMapping(value = "/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        return orgService.get(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable Long id) {
        orgService.delete(id);
    }

    @GetMapping(value = "/getall")
    public List<Organization> findAll() {
        return orgService.findAll();
    }
}
