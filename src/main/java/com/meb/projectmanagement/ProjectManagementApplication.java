package com.meb.projectmanagement;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectManagementApplication {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;



    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
