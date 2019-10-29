package com.employeeregistry.task.controller;


import com.employeeregistry.task.domain.Employee;
import com.employeeregistry.task.service.IEmployeeService;
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
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final IEmployeeService<Employee> employeeService;

    @Autowired
    public EmployeeController(IEmployeeService<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @PostMapping(value = "/save/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.insert(id, employee);
    }

    @PostMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @GetMapping(value = "/getallemployees/{id}")
    public List<Employee> findAllByOrgId(@PathVariable Long id) {
        return employeeService.findAllByOrgId(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @DeleteMapping(value = "/deletebyorg/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllEmployees(@PathVariable Long id) {
        employeeService.deleteAllByOrgId(id);
    }

    @GetMapping(value = "/getall")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/getbypos/{position}")
    public List<Employee> findByPosition(@PathVariable String position) {
        return employeeService.findByPosition(position);
    }

    @GetMapping(value = "/getbyyears/{years}")
    public List<Employee> findAll(@PathVariable Double years) {
        return employeeService.filterByYearsInCompany(years);
    }
}
