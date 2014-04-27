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
@Embeddable
public class Payment implements Serializable {
   
     private Long id;
    private String date;
    private double salary;
    
    
     private Payment(){

    }

    private Payment(Builder builder) {
        id=builder.id;
        date= builder.date;
        salary=builder.salary;
       

    }

    public static class Builder{
        private Long id;
    private String date;
    private double salary;
    

        public Builder(String date,double salary) {
            this.date = date;
            this.salary=salary;
            
        }

        public Builder id(Long value){
            id=value;
            return this;
        }

       
        
         public Builder date(Payment value){
            id = value.getId();
            date = value.getDate();
            salary = value.getSalary();
                      
            return this;
        }

        public Payment build(){
            return new Payment(this);
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
/*
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Payment other = (Payment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", date=" + date + ", salary=" + salary + '}';
    }
*/
    
}
