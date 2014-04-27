/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author mikiahidjo
 */
@Embeddable
public  class JobGrade implements Serializable{
    
     private String id;
    private String name;
   
   
    private JobGrade()
    {
        
    }
    
    private JobGrade(Builder builder) {
        id=builder.id;
        name= builder.name;
       }

    public static class Builder{
        private String id;
    private String name;
   
  

        public Builder(String name) {
            
            this.name = name;
        }

         public Builder id(String value){
            id=value;
            return this;
        }

       
        
        public Builder name(JobGrade value){
            id = value.getId();
            name = value.getName();
                  
            return this;
        }

        public JobGrade build(){
            return new JobGrade(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  /*   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JobGrade other = (JobGrade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JobGrade{" + "id=" + id + ", name=" + name + '}';
    }
  */
}
