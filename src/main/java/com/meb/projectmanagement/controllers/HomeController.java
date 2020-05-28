package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.entities.Employee;
import com.meb.projectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {

        // we are querying the database for all projects

        List<Project> projects = projectRepository.findAll();

        // we are querying the database for all employees

        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("employeesList", employees);
        model.addAttribute("projectsList", projects);

        return "home";
    }

}
