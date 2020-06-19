package com.meb.projectmanagement.services;

import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.dto.ChartData;
import com.meb.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveProject(Project project) {

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    public List<ChartData> getProjectStatuses() {
        return projectRepository.getProjectStatuses();
    }

    public Project getProjectById(Long id) throws ResponseStatusException {

        Optional<Project> projectOptional = projectRepository.findById(id);

        return projectOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "404. Couldn't found Project by id: " + id));
    }

    public void deleteProjectById(Long id) {

        projectRepository.deleteById(id);
    }

    public Iterable<Project> findPaginatedProjects(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return projectRepository.findAll(pageable);
    }
}
