package com.employeeregistry.task.controller;


import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final IEmployeeService<Employee> employeeService;

    @Autowired
    public EmployeeController(IEmployeeService<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
//  @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.insert(employee);
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @GetMapping(value = "/getallemployee/{id}")
    public List<Employee> findAllByOrgId(@PathVariable Long id) {
        return employeeService.findAllByOrgId(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @DeleteMapping(value = "/deleteall/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllEmployees(@PathVariable Long id) {
        employeeService.deleteAllByOrgId(id);
    }

    @GetMapping(value = "/getall")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
