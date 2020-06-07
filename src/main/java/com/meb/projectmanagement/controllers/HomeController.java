package com.meb.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meb.projectmanagement.dto.ChartData;
import com.meb.projectmanagement.dto.EmployeeProject;
import com.meb.projectmanagement.entities.Project;
import com.meb.projectmanagement.services.EmployeeService;
import com.meb.projectmanagement.services.ProjectService;
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

    ProjectService projectService;
    EmployeeService employeeService;

    @Autowired
    public HomeController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("versionNumber", ver);

        // we are querying the database for all projects

        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projectsList", projects);

        // we are querying the database for all employees with their respective project count

        List<EmployeeProject> employeesProjectCount = employeeService.getEmployeesProjects();
        model.addAttribute("employeesListProjectsCount", employeesProjectCount);

        List<ChartData> projectData =  projectService.getProjectStatuses();

        // lets convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCount", jsonString);

        return "main/home";
    }
}
