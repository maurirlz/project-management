package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping()
    public String displayEmployees(Model model) {

        List<Employee> employeeList = employeeRepository.findAll();

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

        employeeRepository.save(employee);

        return "redirect:/employees/new";
    }


}
