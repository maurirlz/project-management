package com.meb.projectmanagement.validators;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public UniqueValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void initialize(UniqueValue constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Employee emp = employeeRepository.findByEmailAddress(s);

        System.out.println("Entered validation method..");

        return emp == null;
    }
}
