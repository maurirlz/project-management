package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
