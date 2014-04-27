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
import javax.persistence.Column;
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
public class Employee implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique= true)
    private String Email;
    @Embedded
    private Contact contact;
    @Embedded
    private Payment payment;
    @OneToMany
    @JoinColumn(name="Employee_id")
     List<ProjectAssign> passign; 
    @OneToMany
    @JoinColumn(name="Employee_id")
     List<JobHistory> jobhistory;
    @OneToMany
    @JoinColumn(name="Employee_id")
     List<Office>office;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Employee_id")
     List<Qualification>qualification;
            
   
   
    
     private Employee(){

    }

    private Employee(Builder builder) {
        id=builder.id;
        firstname= builder.firstname;
        lastname=builder.lastname;
        contact =builder.contact;
        payment = builder.payment;
        passign=builder.passign;
        jobhistory=builder.jobhistory;
        office=builder.office;
        qualification=builder.qualification;
               

    }

    public static class Builder{
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Contact contact;
    private Payment payment;
    List<ProjectAssign>passign;
    List<JobHistory>jobhistory;
    List<Office>office;
    List<Qualification>qualification;
   
    
        public Builder(String firstname,String lastname, String Email) {
            this.firstname = firstname;
            this.lastname=lastname;
            this.email=email;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }
         public Builder contact(Contact value){
            contact=value;
            return this;
        }
          public Builder payment(Payment value){
            payment=value;
            return this;
        }


        public Builder passign(List<ProjectAssign> value){
            passign=value;
            return this;
        }
         public Builder jobhistory(List<JobHistory> value){
            jobhistory=value;
            return this;
        }
          public Builder office(List<Office> value){
            office=value;
            return this;
        }
           
         public Builder qualification(List<Qualification> value){
            qualification=value;
            return this;
        }
         
          public Builder name(Employee value){
            id = value.getId();
            firstname = value.getFirstname();
            lastname= value.getLastname();
            email=value.getEmail();
            contact=value.getContact();
            payment =value.getPayment();
            passign =value.getPassign();
            jobhistory = value.getJobhistory();
            office =value.getOffice();
            qualification=value.getQualification();
            
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    

    public List<ProjectAssign> getPassign() {
        return passign;
    }

    public void setPassign(List<ProjectAssign> passign) {
        this.passign = passign;
    }

    public List<JobHistory> getJobhistory() {
        return jobhistory;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setJobhistory(List<JobHistory> jobhistory) {
        this.jobhistory = jobhistory;
    }

    public List<Office> getOffice() {
        return office;
    }

    public void setOffice(List<Office> office) {
        this.office = office;
    }

    public List<Qualification> getQualification() {
        return qualification;
    }

    public void setQualification(List<Qualification> qualification) {
        this.qualification = qualification;
    }

    

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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
      return "com.tchouyangoko.humain.domain.Employee[ id=" + id + " ]";// return "Employee{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", Email=" + Email + ", contact=" + contact + ", payment=" + payment + ", passign=" + passign + ", jobhistory=" + jobhistory + ", office=" + office + ", qualification=" + qualification + '}';
    }

      
}
