package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.entities.Project;
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

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();

        model.addAttribute("project", aProject);

        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Model model, Project project) {
        // handles saving to the database.

        projectRepository.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }

    @GetMapping(value = "/list")
    public String displayProjects(Model model) {

        List<Project> projects = projectRepository.findAll();

        model.addAttribute("projectsList", projects);

        return "projects/project-home";
    }
}
