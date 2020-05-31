package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.dto.ChartData;
import com.meb.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage AS label, COUNT(*) AS value FROM project GROUP BY stage")
    List<ChartData> projectsStatuses();
}
