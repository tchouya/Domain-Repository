/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mikiahidjo
 */
@Entity
public  class JobHistory implements Serializable{
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Embedded
    private Title title;
    private JobHistory(){

    }

    private JobHistory(Builder builder) {
         id=builder.id;
        description= builder.description;
        title = builder.title;
    }

    public static class Builder{
      private Long id;
    private String description;
    private Title title;

        public Builder(String description) {
            this.description = description;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }
         public Builder title(Title value){
            title=value;
            return this;
        }
       public Builder endate(JobHistory value){
            id = value.getId();
            description = value.getDescription();
            title = value.getTitle();
            return this;
        }
       

        public JobHistory build(){
            return new JobHistory(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final JobHistory other = (JobHistory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
      return "com.tchouyangoko.humain.domain.JobHistory[ id=" + id + " ]";  //return "JobHistory{" + "id=" + id + ", description=" + description + ", title=" + title + '}';
    }

    
    
}
