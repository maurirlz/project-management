package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.entities.Employee;
import com.meb.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String displayEmployees(Model model) {

        List<Employee> employeeList = employeeService.getAllEmployees();

        model.addAttribute("employeesList", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee newEmployee = new Employee();

        model.addAttribute("employee", newEmployee);

        return "./employees/new-employee";
    }

    @PostMapping(value = "/save")
    public String createEmployee(Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees/new";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long theId, Model model) {

        Employee employee = employeeService.findEmployeeById(theId);
        model.addAttribute("employee", employee);

        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long theId) {

        employeeService.deleteEmployeeById(theId);

        return "redirect:/employees";
    }
}
