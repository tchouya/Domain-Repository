/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Job;
import com.tchouyangoko.humain.domain.JobGrade;
import com.tchouyangoko.humain.repository.JobRepository;
import java.util.List;
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
public class JobRepositoryTest {
    
    public  static ApplicationContext ctx;
    private Long id;
    private JobRepository repo;
    public JobRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
   
   @Test
    public void createJob(){
    repo = ctx.getBean(JobRepository.class);
 
   Job j = new Job.Builder("Development software",3000.0,8700.0).build();
   
   JobGrade t = new JobGrade.Builder("Project manager").id("A").build();
  
     j.setJograde(t);
     repo.save(j);
     id = j.getId();
     Assert.assertNotNull(j);
             
    }  
    
       
    @Test(dependsOnMethods = "createJob")
     public void readJob(){
         repo = ctx.getBean(JobRepository.class);
         Job c = repo.findOne(id);
         Assert.assertEquals(c.getMin_salary(),3000.0);
         
     }
     
     
     @Test(dependsOnMethods = "readJob")
     private void updateJob(){
         repo = ctx.getBean(JobRepository.class);
         Job c = repo.findOne(id);
         c.setMin_salary(4000.0);
         repo.save(c);
         
         Job updateJob = repo.findOne(id);
         Assert.assertEquals(updateJob.getMin_salary(),4000.0);
         
     }
     
      
     
      @Test(dependsOnMethods = "updateJob")
     private void deleteJob(){
         repo = ctx.getBean(JobRepository.class);
         Job c = repo.findOne(id);
         repo.delete(c);
         
         Job deletedJob = repo.findOne(id);
         
         Assert.assertNull(deletedJob);
         
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
