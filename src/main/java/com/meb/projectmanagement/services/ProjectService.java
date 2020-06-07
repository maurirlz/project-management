package com.meb.projectmanagement.services;

import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.dto.ChartData;
import com.meb.projectmanagement.dto.EmployeeProject;
import com.meb.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project) {

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    public List<ChartData> getProjectStatuses() {
        return projectRepository.getProjectStatuses();
    }
}
