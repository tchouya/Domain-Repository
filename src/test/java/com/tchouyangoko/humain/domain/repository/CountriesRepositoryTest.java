/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Countries;
import com.tchouyangoko.humain.domain.Region;
import com.tchouyangoko.humain.repository.CountriesRepository;
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
public class CountriesRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private CountriesRepository repo;
    
     
    
      public CountriesRepositoryTest() {
     }
      
    @Test
    public void createCountries(){
    repo = ctx.getBean(CountriesRepository.class);
    Countries c = new Countries.Builder("South").build();
    Region r = new Region.Builder("south of Africa").id(27L).build();
     
    
     //Countries c = new Countries();
    // c.setName("South");
     //Region r = new Region();
    // r.setName("south of Africa");
     //r.setId(1L);
     c.setRegion(r);
     repo.save(c);
     id = c.getId();
     Assert.assertNotNull(c);
         
    }  
   
    @Test(dependsOnMethods = "createCountries")
     public void readCountries(){
         repo = ctx.getBean(CountriesRepository.class);
         Countries c = repo.findOne(id);
         Assert.assertEquals(c.getName(),"South");
         
     }
     
     
     @Test(dependsOnMethods = "readCountries")
     private void updateCountries(){
         repo = ctx.getBean(CountriesRepository.class);
         Countries c = repo.findOne(id);
         c.setName("South Afica");
         repo.save(c);
         
         Countries updateCountries = repo.findOne(id);
         Assert.assertEquals(updateCountries.getName(), "South Afica");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateCountries")
     private void deleteCountries(){
         repo = ctx.getBean(CountriesRepository.class);
         Countries c = repo.findOne(id);
         repo.delete(c);
         
         Countries deletedCountries = repo.findOne(id);
         
         Assert.assertNull(deletedCountries);
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
