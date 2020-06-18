package com.meb.projectmanagement.services;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dto.EmployeeProject;
import com.meb.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee emp) {

       return employeeRepository.save(emp);
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public List<EmployeeProject> getEmployeesProjects() {

        return employeeRepository.getEmployeeProjects();
    }

    public Employee findById(Long id) {

        Optional<Employee> employeeOrNull = employeeRepository.findById(id);

        return employeeOrNull.orElse(null);
    }

    public void deleteEmployeeById(Long id) {

        employeeRepository.deleteById(id);
    }
}
