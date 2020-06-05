package com.meb.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.dto.ChartData;
import com.meb.projectmanagement.dto.EmployeeProject;
import com.meb.projectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    ProjectRepository projectRepository;
    EmployeeRepository employeeRepository;

    @Autowired
    public HomeController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("versionNumber", ver);

        // we are querying the database for all projects

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        // we are querying the database for all employees with their respective project count

        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        model.addAttribute("employeesListProjectsCount", employeesProjectCount);

        List<ChartData> projectData = projectRepository.projectsStatuses();

        // lets convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCount", jsonString);

        return "main/home";
    }
}
