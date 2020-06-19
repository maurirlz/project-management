package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.dto.EmployeeProject;
import com.meb.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) as projectCount " +
            " FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id " +
            " GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    List<EmployeeProject> getEmployeeProjects();

    Employee findByEmailAddress(String s);
}
