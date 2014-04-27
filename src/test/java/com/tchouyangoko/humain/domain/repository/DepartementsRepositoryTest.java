/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.DepartementHistory;
import com.tchouyangoko.humain.domain.Departements;
import com.tchouyangoko.humain.repository.DepartementsRepository;
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
public class DepartementsRepositoryTest {
     public  static ApplicationContext ctx;
    private Long id;
    private DepartementsRepository repo;
    
    public DepartementsRepositoryTest() {
    }

    
   
    @Test
    public void createDepartements(){
    repo = ctx.getBean(DepartementsRepository.class);
    Departements d = new Departements.Builder("Information technology").build();
    DepartementHistory h = new DepartementHistory.Builder("have realise two projets").id(201L).build();
     
    
     /*Departements c = new Departements();
     c.setName("Information technology");
     DepartementsHistory h = new DepartementsHistory();
     d.setName("have realise two projets");
     h.setId(201L);*/
     d.setDephistory(h);
     repo.save(d);
     id = d.getId();
     Assert.assertNotNull(d);
         
    }  
    
       
    @Test(dependsOnMethods = "createDepartements")
     public void readDepartements(){
         repo = ctx.getBean(DepartementsRepository.class);
         Departements c = repo.findOne(id);
         Assert.assertEquals(c.getName(),"Information technology");
         
     }
     
     
     @Test(dependsOnMethods = "readDepartements")
     private void updateDepartements(){
         repo = ctx.getBean(DepartementsRepository.class);
         Departements c = repo.findOne(id);
         c.setName("Administration");
         repo.save(c);
         
         Departements updateDepartements = repo.findOne(id);
         Assert.assertEquals(updateDepartements.getName(), "Administration");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateDepartements")
     private void deleteDepartements(){
         repo = ctx.getBean(DepartementsRepository.class);
         Departements c = repo.findOne(id);
         repo.delete(c);
         
         Departements deletedDepartements = repo.findOne(id);
         Assert.assertNull(deletedDepartements);
         
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
