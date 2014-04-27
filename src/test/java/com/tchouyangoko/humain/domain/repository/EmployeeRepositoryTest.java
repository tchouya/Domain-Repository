/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Contact;
import com.tchouyangoko.humain.domain.Employee;
import com.tchouyangoko.humain.domain.Payment;
import com.tchouyangoko.humain.repository.EmployeeRepository;
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
public class EmployeeRepositoryTest {
    
    public EmployeeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     public  static ApplicationContext ctx;
    private Long id;
    private EmployeeRepository repo;
    
 
    @Test
    public void createEmployee(){
    repo = ctx.getBean(EmployeeRepository.class);
    Employee d = new Employee.Builder("Tchouya","Israel","tchouya@gmail.com").build();
    Contact c = new Contact.Builder("p.O.Box 13","2424253").landline("12345").build();
    Payment p = new Payment.Builder("31 april 2010",6000.0).id(0012L).build();
    
     
    
     /*Employee c = new Employee();
     c.setFirstname("Tchouya");
     
      Contact c = new Contact();
         c.setAddress("p.O.Box 13");
         c.setCell("2424253");
         c.setLandline("12345");;*/
     d.setContact(c);
     d.setPayment(p);
     repo.save(d);
     id = d.getId();
     
     Assert.assertNotNull(d);
         
    }  
    
       
    @Test(dependsOnMethods = "createEmployee")
     public void readEmployee(){
         repo = ctx.getBean(EmployeeRepository.class);
         Employee c = repo.findOne(id);
         Assert.assertEquals(c.getEmail(),"tchouya@gmail.com");
         
     }
     
     
     @Test(dependsOnMethods = "readEmployee")
     private void updateEmployee(){
         repo = ctx.getBean(EmployeeRepository.class);
         Employee c = repo.findOne(id);
         c.setEmail("miki@yahoo.fr");
         repo.save(c);
         
         Employee updateEmployee = repo.findOne(id);
         Assert.assertEquals(updateEmployee.getEmail(), "miki@yahoo.fr");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateEmployee")
     private void deletePerson(){
         repo = ctx.getBean(EmployeeRepository.class);
         Employee c = repo.findOne(id);
         repo.delete(c);
         
         Employee deletedEmployee = repo.findOne(id);
         Assert.assertNull(deletedEmployee);
         
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
