/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author mikiahidjo
 */
@Entity
public  class Job implements Serializable{
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String title;
    private double min_salary;
    private double max_salary;
    @OneToMany
    @JoinColumn(name="Job_id")
    List<JobHistory>jobhistory;
    @Embedded    
    private JobGrade jograde;
     private Job(){

    }

    private Job(Builder builder) {
       id=builder.id;
        title= builder.title;
        min_salary=builder.min_salary;
        max_salary =builder.max_salary;
        jobhistory =builder.jobhistory;
        jograde = builder.jograde;
    }

    public static class Builder{
        private Long id;
    private String title;
    private double min_salary;
    private double max_salary;
    private JobGrade jograde;
    
    List<JobHistory>jobhistory;
     

        public Builder(String title,double min_salary,double max_salary) {
            
            this.title = title;
            this.min_salary = min_salary;
            this.max_salary = max_salary;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }

        public Builder jobhistory( List<JobHistory> value){
            jobhistory=value;
            return this;
        }
         public Builder jograde( JobGrade value){
            jograde=value;
            return this;
        }
        
        public Builder title(Job value){
            id= value.getId();
            title = value.getTitle();
            min_salary = value.getMin_salary();
            max_salary = value.getMax_salary();
            jobhistory =value.getJobhistory();
             jograde = value.getJograde();
            return this;
        }

        public Job build(){
            return new Job(this);
        }
    }

   

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(double min_salary) {
        this.min_salary = min_salary;
    }

    public double getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(double max_salary) {
        this.max_salary = max_salary;
    }

    public List<JobHistory> getJobhistory() {
        return jobhistory;
    }

    public void setJobhistory(List<JobHistory> jobhistory) {
        this.jobhistory = jobhistory;
    }

    public JobGrade getJograde() {
        return jograde;
    }

    public void setJograde(JobGrade jograde) {
        this.jograde = jograde;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Job other = (Job) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       return "com.tchouyangoko.humain.domain.Job[ id=" + id + " ]"; //return "Job{" + "id=" + id + ", title=" + title + ", min_salary=" + min_salary + ", max_salary=" + max_salary + ", jobhistory=" + jobhistory + '}';
    }

   
}
