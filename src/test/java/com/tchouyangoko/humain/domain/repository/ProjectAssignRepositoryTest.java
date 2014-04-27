/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.ProjectAssign;
import com.tchouyangoko.humain.repository.ProjectAssignRepository;
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
public class ProjectAssignRepositoryTest {
    
     public  static ApplicationContext ctx;
    private Long id;
    private ProjectAssignRepository repo;
    public ProjectAssignRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createProjectAssign(){
    repo = ctx.getBean(ProjectAssignRepository.class);
    ProjectAssign d = new ProjectAssign.Builder("20 mai 2013",100000.0).build();
       
   
     repo.save(d);
     id = d.getId();
     
     Assert.assertNotNull(d);
         
    }  
    
       
    @Test(dependsOnMethods = "createProjectAssign")
     public void readProjectAssign(){
         repo = ctx.getBean(ProjectAssignRepository.class);
         ProjectAssign c = repo.findOne(id);
         Assert.assertEquals(c.getDate(),"20 mai 2013");
         
     }
     
     
     @Test(dependsOnMethods = "readProjectAssign")
     private void updateProjectAssign(){
         repo = ctx.getBean(ProjectAssignRepository.class);
         ProjectAssign c = repo.findOne(id);
         c.setDate("30 mai 2013");
         repo.save(c);
         
         ProjectAssign updateProjectAssign = repo.findOne(id);
         Assert.assertEquals(updateProjectAssign.getDate(), "30 mai 2013");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateProjectAssign")
     private void deleteProjectAssign(){
         repo = ctx.getBean(ProjectAssignRepository.class);
         ProjectAssign c = repo.findOne(id);
         repo.delete(c);
         
         ProjectAssign deletedProjectAssign = repo.findOne(id);
         Assert.assertNull(deletedProjectAssign);
         
     }


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
