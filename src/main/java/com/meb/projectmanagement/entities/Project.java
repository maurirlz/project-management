package com.meb.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    private long projectId;

    @NotBlank(message="Field doesn't accept blank spaces")
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank(message="Field doesn't accept blank spaces")
    @Size(min = 9, max = 13)
    private String stage; // NOTSTARTED, COMPLETED, INPROGRESS

    @NotBlank(message="Field doesn't accept blank spaces")
    @Size(min = 10, max = 250)
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee",
              joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))

    @JsonIgnore
    private List<Employee> employees;

    public Project() {
    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public void addEmployee(Employee emp) {

        if (employees == null) {

            employees = new ArrayList<>();
        }

        employees.add(emp);
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
