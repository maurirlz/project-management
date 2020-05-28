package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
