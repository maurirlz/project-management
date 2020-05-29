package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.entities.Employee;
import com.meb.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/projects")
@Controller
public class ProjectController {

    ProjectRepository projectRepository;

    EmployeeRepository employeeRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String displayProjects(Model model) {

        List<Project> projects = projectRepository.findAll();

        model.addAttribute("projectsList", projects);

        return "/projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();

        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Model model, Project project) {
        // handles saving to the database.

        projectRepository.save(project);

        List<Employee> employees = project.getEmployees();

        Employee e;
        for (int i = 0; i < employees.size(); i++) {
            e = employees.get(i);
            e.setAssignedProject(project);
            employeeRepository.save(e);
        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
