/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Project;
import com.tchouyangoko.humain.repository.ProjectRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author mikiahidjo
 */
public class ProjectRepositoryTest {
    
     public  static ApplicationContext ctx;
    private Long id;
    private ProjectRepository repo;
    
    public ProjectRepositoryTest() {
    }

 
    @Test
    public void createProject(){
    repo = ctx.getBean(ProjectRepository.class);
     Project d = new Project.Builder("Airline Reservation","Create a website of an Airline").build();
        
    
     repo.save(d);
     id = d.getId();
     
     Assert.assertNotNull(d);
         
    }  
    
       
    @Test(dependsOnMethods = "createProject")
     public void readProject(){
         repo = ctx.getBean(ProjectRepository.class);
         Project c = repo.findOne(id);
         Assert.assertEquals(c.getDescription(),"Create a website of an Airline");
         
     }
     
     
     @Test(dependsOnMethods = "readProject")
     private void updateProject(){
         repo = ctx.getBean(ProjectRepository.class);
         Project c = repo.findOne(id);
         c.setDescription("Design of an Airline");
         repo.save(c);
         
         Project updateProject = repo.findOne(id);
         Assert.assertEquals(updateProject.getDescription(), "Design of an Airline");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateProject")
     private void deleteProject(){
         repo = ctx.getBean(ProjectRepository.class);
         Project c = repo.findOne(id);
         repo.delete(c);
         
         Project deletedProject = repo.findOne(id);
         Assert.assertNull(deletedProject);
         
     }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
