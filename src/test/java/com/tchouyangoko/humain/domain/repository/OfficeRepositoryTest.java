/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Office;
import com.tchouyangoko.humain.repository.OfficeRepository;
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
public class OfficeRepositoryTest {
    
    public OfficeRepositoryTest() {
    }

    public  static ApplicationContext ctx;
    private Long id;
    private OfficeRepository repo;
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
    public void createOffice(){
    repo = ctx.getBean(OfficeRepository.class);
 
   Office j = new Office.Builder("Direction").build();
   
  
     repo.save(j);
     id = j.getId();
     Assert.assertNotNull(j);
             
    }  
    
       
    @Test(dependsOnMethods = "createOffice")
     public void readOffice(){
         repo = ctx.getBean(OfficeRepository.class);
         Office c = repo.findOne(id);
         Assert.assertEquals(c.getName(),"Direction");
         
     }
     
     
     @Test(dependsOnMethods = "readOffice")
     private void updateOffice(){
         repo = ctx.getBean(OfficeRepository.class);
         Office c = repo.findOne(id);
         c.setName("International Office");
         repo.save(c);
         
         Office updateOffice = repo.findOne(id);
         Assert.assertEquals(updateOffice.getName(),"International Office");
         
     }
     
      @Test(dependsOnMethods = "updateOffice")
     private void deleteOffice(){
         repo = ctx.getBean(OfficeRepository.class);
         Office c = repo.findOne(id);
         repo.delete(c);
         
         Office deletedOffice = repo.findOne(id);
         
         Assert.assertNull(deletedOffice);
         
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
