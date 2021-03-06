package com.meb.projectmanagement.api.controllers;

import com.meb.projectmanagement.entities.Project;
import com.meb.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    private final ProjectService projectService;

    @Autowired
    public ProjectApiController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public Iterable<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    @GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Project> getPaginatedProjects(@RequestParam("page") int page, @RequestParam("size") int size) {

        return projectService.findPaginatedProjects(page, size);
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {

        try {

            return projectService.getProjectById(id);
        } catch (ResponseStatusException ignored) {

        }

        return null;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project postProject(@RequestBody Project project) {

        return projectService.saveProject(project);
    }

    @PutMapping(path = "id")
    @ResponseStatus(HttpStatus.OK)
    public Project updateWholeProject(@RequestBody @Valid Project newProject) {

        return projectService.saveProject(newProject);
    }

    @PatchMapping(consumes = "application/json", path = "{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Project patchProject(@PathVariable("id") Long id, @RequestBody Project updatedProject) {

        Project oldProject = projectService.getProjectById(id);
        String updatedProjectName = updatedProject.getName();
        String updatedProjectDescription = updatedProject.getDescription();
        String updatedProjectStage = updatedProject.getStage();

        if (updatedProjectDescription != null) {

            oldProject.setDescription(updatedProjectDescription);
        }

        if (updatedProjectName != null) {

            oldProject.setName(updatedProjectName);
        }

        if (updatedProjectStage != null) {

            oldProject.setStage(updatedProjectStage);
        }

        return projectService.saveProject(oldProject);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {

        try {

            projectService.deleteProjectById(id);
        } catch (EmptyResultDataAccessException ignored) {}
    }
}
