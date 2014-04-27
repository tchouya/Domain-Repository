/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.JobHistory;
import com.tchouyangoko.humain.domain.Title;
import com.tchouyangoko.humain.repository.JobHistoryRepository;
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
public class JobHistoryRepositoryTest {
    
     public  static ApplicationContext ctx;
    private Long id;
    private JobHistoryRepository repo;
    public JobHistoryRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
    public void createJobHistory(){
    repo = ctx.getBean(JobHistoryRepository.class);
 
    JobHistory j = new JobHistory.Builder("Start in january 2014").build();
     Title t = new Title.Builder("history of the company").id(1L).build();
  
     j.setTitle(t);
     repo.save(j);
     id = j.getId();
     Assert.assertNotNull(j);
         
    }  
    
       
    @Test(dependsOnMethods = "createJobHistory")
     public void readJobHistory(){
         repo = ctx.getBean(JobHistoryRepository.class);
         JobHistory c = repo.findOne(id);
         Assert.assertEquals(c.getDescription(),"Start in january 2014");
         
     }
     
     
     @Test(dependsOnMethods = "readJobHistory")
     private void updateJobHistory(){
         repo = ctx.getBean(JobHistoryRepository.class);
         JobHistory c = repo.findOne(id);
         c.setDescription("Start in May 2014");
         repo.save(c);
         
         JobHistory updateJobHistory = repo.findOne(id);
         Assert.assertEquals(updateJobHistory.getDescription(), "Start in May 2014");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateJobHistory")
     private void deleteJobHistory(){
         repo = ctx.getBean(JobHistoryRepository.class);
         JobHistory c = repo.findOne(id);
         repo.delete(c);
         
         JobHistory deletedJobHistory = repo.findOne(id);
         
         Assert.assertNull(deletedJobHistory);
         
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
