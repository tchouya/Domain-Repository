/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Qualification;
import com.tchouyangoko.humain.repository.QualificationRepository;
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
public class QualificationRepositoryTest {
    
    public  static ApplicationContext ctx;
    private Long id;
    private QualificationRepository repo;
    
    public QualificationRepositoryTest() {
    }

    
  
    @Test
    public void createQualification(){
    repo = ctx.getBean(QualificationRepository.class);
     Qualification d = new Qualification.Builder("national Diploma").build();
    
     repo.save(d);
     id = d.getId();
     
     Assert.assertNotNull(d);
         
    }  
    
       
    @Test(dependsOnMethods = "createQualification")
     public void readQualification(){
         repo = ctx.getBean(QualificationRepository.class);
         Qualification c = repo.findOne(id);
         Assert.assertEquals(c.getName(),"national Diploma");
         
     }
     
     
     @Test(dependsOnMethods = "readQualification")
     private void updateQualification(){
         repo = ctx.getBean(QualificationRepository.class);
         Qualification c = repo.findOne(id);
         c.setName("Degre");
         repo.save(c);
         
         Qualification updateQualification = repo.findOne(id);
         Assert.assertEquals(updateQualification.getName(), "Degre");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateQualification")
     private void deleteQualification(){
         repo = ctx.getBean(QualificationRepository.class);
         Qualification c = repo.findOne(id);
         repo.delete(c);
         
         Qualification deletedQualification = repo.findOne(id);
         Assert.assertNull(deletedQualification);
         
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
