/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain.repository;

import com.tchouyangoko.humain.app.config.ConnectionConfig;
import com.tchouyangoko.humain.domain.Skill;
import com.tchouyangoko.humain.repository.SkillRepository;
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
public class SkillRepositoryTest {
    
    public SkillRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     public  static ApplicationContext ctx;
    private Long id;
    private SkillRepository repo;
    
   
 
    @Test
    public void createSkill(){
    repo = ctx.getBean(SkillRepository.class);
      Skill d = new Skill.Builder("Developer").build();
       
    
     repo.save(d);
     id = d.getId();
     
     Assert.assertNotNull(d);
         
    }  
    
       
    @Test(dependsOnMethods = "createSkill")
     public void readSkill(){
         repo = ctx.getBean(SkillRepository.class);
         Skill c = repo.findOne(id);
         Assert.assertEquals(c.getName(),"Developer");
         
     }
     
     
     @Test(dependsOnMethods = "readSkill")
     private void updateSkill(){
         repo = ctx.getBean(SkillRepository.class);
         Skill c = repo.findOne(id);
         c.setName("Designer");
         repo.save(c);
         
         Skill updateSkill = repo.findOne(id);
         Assert.assertEquals(updateSkill.getName(), "Designer");
         
     }
     
      
     
      @Test(dependsOnMethods = "updateSkill")
     private void deleteSkill(){
         repo = ctx.getBean(SkillRepository.class);
         Skill c = repo.findOne(id);
         repo.delete(c);
         
         Skill deletedSkill = repo.findOne(id);
         Assert.assertNull(deletedSkill);
         
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
