package com.meb.pma.dao;

import com.meb.projectmanagement.ProjectManagementApplication;
import com.meb.projectmanagement.dao.ProjectRepository;
import com.meb.projectmanagement.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ContextConfiguration(classes= ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository proRepo;

    @Test
    public void IfNewProjectSaved_thenSuccess() {
        Project project = new Project("New Test Project", "COMPLETED", "Test Description");

        proRepo.save(project);
        assertEquals(5, proRepo.findAll().size());
    }
}
