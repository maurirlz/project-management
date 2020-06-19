package com.meb.projectmanagement.services;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dto.EmployeeProject;
import com.meb.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Iterable<Employee> getAllEmployeesPaginated(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return employeeRepository.findAll(pageable);
    }

    public List<EmployeeProject> getEmployeesProjects() {

        return employeeRepository.getEmployeeProjects();
    }

    public Employee findById(Long id) {

        Optional<Employee> employeeOrNull = employeeRepository.findById(id);

        return employeeOrNull.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "404. Couldn't found Employee by id: " + id));
    }

    public void deleteEmployeeById(Long id) {

        employeeRepository.deleteById(id);
    }

}
