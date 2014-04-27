/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mikiahidjo
 */
@Entity
public  class ProjectAssign implements Serializable{
  private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private double budget;
    
     private ProjectAssign(){

    }

    private ProjectAssign(Builder builder) {
       id=builder.id;
        date= builder.date;
        budget=builder.budget;

    }

    public static class Builder{
       private Long id;
    private String date;
    private double budget;

        public Builder(String date,double budget) {
            this.date = date;
            this.budget = budget;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }

       public Builder date(ProjectAssign value){
            id = value.getId();
            date = value.getDate();
            budget = value.getBudget();
             return this;
        }

        public ProjectAssign build(){
            return new ProjectAssign(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ProjectAssign other = (ProjectAssign) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
     return  "com.tchouyangoko.humain.domain.ProjectAssign[ id=" + id + " ]"; // return "ProjectAssign{" + "id=" + id + ", date=" + date + ", budget=" + budget + '}';
    }

    
}
