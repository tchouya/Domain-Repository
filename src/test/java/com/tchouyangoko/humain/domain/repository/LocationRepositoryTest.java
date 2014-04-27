/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Location;
import com.tchouyangoko.humain.repository.LocationRepository;
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
public class LocationRepositoryTest {
    public  static ApplicationContext ctx;
    private Long id;
    private LocationRepository repo;
    
    public LocationRepositoryTest() {
    }
    
     
   
   @Test
    public void createLocation(){
    repo = ctx.getBean(LocationRepository.class);
 
   Location j = new Location.Builder("william Street","Cape town").build();
     repo.save(j);
     id = j.getId();
     Assert.assertNotNull(j);
             
    }  
    
       
    @Test(dependsOnMethods = "createLocation")
     public void readLocation(){
         repo = ctx.getBean(LocationRepository.class);
         Location c = repo.findOne(id);
         Assert.assertEquals(c.getStreet_address(),"william Street");
         
     }
     
     
     @Test(dependsOnMethods = "readLocation")
     private void updateLocation(){
         repo = ctx.getBean(LocationRepository.class);
         Location c = repo.findOne(id);
         c.setStreet_address("Montelvo");
         repo.save(c);
         
         Location updateLocation = repo.findOne(id);
         Assert.assertEquals(updateLocation.getStreet_address(),"Montelvo");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateLocation")
     private void deleteLocation(){
         repo = ctx.getBean(LocationRepository.class);
         Location c = repo.findOne(id);
         repo.delete(c);
         
         Location deletedLocation = repo.findOne(id);
         
         Assert.assertNull(deletedLocation);
         
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
