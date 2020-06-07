package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.entities.Employee;
import com.meb.projectmanagement.entities.Project;

import com.meb.projectmanagement.services.EmployeeService;
import com.meb.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/projects")
@Controller
public class ProjectController {

    EmployeeService employeeService;
    ProjectService projectService;

    @Autowired
    public ProjectController(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping
    public String displayProjects(Model model) {

        List<Project> projects = projectService.getAllProjects();

        model.addAttribute("projectsList", projects);

        return "/projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();

        List<Employee> employees = employeeService.getAllEmployees();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project) {
        // handles saving to the database.

        projectService.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects";
    }
}
