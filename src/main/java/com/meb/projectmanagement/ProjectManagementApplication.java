package com.meb.projectmanagement;

import com.meb.projectmanagement.dao.EmployeeRepository;
import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.entities.Employee;
import com.meb.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner runner() {
//
////        return args -> {
////
////            Employee emp1 = new Employee("Mauricio", "Benitez", "test@gmail.com");
////            Employee emp2 = new Employee("Juan", "Martin", "pelado@gmail.com");
////            Employee emp3 = new Employee("Guido", "Forastello", "fortachon@gmail.com");
////
////            Employee emp4 = new Employee("Rafael", "De Souza", "pein@gmail.com");
////            Employee emp5 = new Employee("Fabian", "Souza", "brasilero@gmail.com");
////            Employee emp6 = new Employee("Shiro", "Waito", "waito@shiro.com");
////
////            Employee emp7 = new Employee("joago", "Enjuago", "joaguin@gmail.com");
////            Employee emp8 = new Employee("gonzalo","sekm","sekm@gmail.com");
////            Employee emp9 = new Employee("samudio","gonzalo","imbecil@gmail.com");
////
////            Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
////                    + "the final deployment of the software into production");
////            Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
////                    + "for the year and figureout who will be promoted");
////            Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
////                    + "been damaged due to hurricane in the region. This needs to be reconstructed");
////            Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
////                    + "security needs to be improved and proper security team needs to be hired for "
////                    + "implementation");
////
////
////            // need to set both sides of the relationship manually
////
////            pro1.addEmployee(emp1);
////            pro1.addEmployee(emp2);
////            pro2.addEmployee(emp3);
////            pro3.addEmployee(emp1);
////            pro4.addEmployee(emp1);
////            pro4.addEmployee(emp3);
////
////
////            // need to set both sides of the relationship manually
////
////            emp1.setAssignedProject(Arrays.asList(pro1, pro3, pro4));
////            emp2.setAssignedProject(Arrays.asList(pro1));
////            emp3.setAssignedProject(Arrays.asList(pro2, pro4));
////
////            // save employees in database
////
////            employeeRepository.save(emp1);
////            employeeRepository.save(emp2);
////            employeeRepository.save(emp3);
////            employeeRepository.save(emp4);
////            employeeRepository.save(emp5);
////            employeeRepository.save(emp6);
////            employeeRepository.save(emp7);
////            employeeRepository.save(emp8);
////            employeeRepository.save(emp9);
////
////
////            // save projects in database
////
////            projectRepository.save(pro1);
////            projectRepository.save(pro2);
////            projectRepository.save(pro3);
////            projectRepository.save(pro4);
////
////        };
////    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
