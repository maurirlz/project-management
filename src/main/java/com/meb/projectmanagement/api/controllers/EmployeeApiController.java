package com.meb.projectmanagement.api.controllers;

import com.meb.projectmanagement.entities.Employee;
import com.meb.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Iterable<Employee> getEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {

        return employeeService.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody @Valid Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@RequestBody @Valid Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @PatchMapping(consumes = "application/json", path = "{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee patchEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee newEmployee) {

        Employee oldEmployee = employeeService.findById(id);
        String newEmployeeFirstName = newEmployee.getFirstName();
        String newEmployeeLastName = newEmployee.getLastName();
        String newEmployeeEmail = newEmployee.getEmailAddress();

        if (newEmployeeFirstName != null) {

            oldEmployee.setFirstName(newEmployeeFirstName);
        }

        if (newEmployeeLastName != null) {

            oldEmployee.setLastName(newEmployeeLastName);
        }

        if (newEmployeeEmail != null) {

            oldEmployee.setEmailAddress(newEmployeeEmail);
        }

        return employeeService.saveEmployee(oldEmployee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        try {

            employeeService.deleteEmployeeById(id);
        } catch (EmptyResultDataAccessException ignored) {

        }
    }
}
