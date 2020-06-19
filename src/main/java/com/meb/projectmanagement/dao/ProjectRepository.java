package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.dto.ChartData;
import com.meb.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path="apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage AS label, COUNT(*) AS value FROM project GROUP BY stage")
    List<ChartData> getProjectStatuses();
}
