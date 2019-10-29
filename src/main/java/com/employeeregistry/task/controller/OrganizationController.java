package com.employeeregistry.task.controller;

import com.employeeregistry.task.domain.Organization;
import com.employeeregistry.task.service.IOrganizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {

    private IOrganizationService<Organization> orgService;

    @Autowired
    public OrganizationController(IOrganizationService<Organization> orgService) {
        this.orgService = orgService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization createOrganization(@PathVariable Long id, @RequestBody Organization organization) {
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
