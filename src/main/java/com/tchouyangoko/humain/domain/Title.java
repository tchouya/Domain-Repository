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
public class Title implements Serializable{
   
     private Long id;
    private String name;
    List<JobHistory>jobHistory;
    
     private Title(){

    }

    private Title(Builder builder) {
        id=builder.id;
        name= builder.name;
        jobHistory=builder.jobHistory;

    }

    public static class Builder{
         private Long id;
         private String name;
         List<JobHistory>jobHistory;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }

        public Builder answers(List<JobHistory> value){
            jobHistory=value;
            return this;
        }
        
        public Builder name(Title value){
            id = value.getId();
            name = value.getName();
            jobHistory=value.getJobHistory();
            return this;
        }

        public Title build(){
            return new Title(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(List<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
    }

  /*  @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Title other = (Title) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Title{" + "id=" + id + ", name=" + name + ", jobHistory=" + jobHistory + '}';
    }
  */
    
}
