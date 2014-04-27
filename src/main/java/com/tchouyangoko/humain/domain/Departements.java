/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
public class Departements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
    private String name;
   @Embedded
   private DepartementHistory dephistory;
   @OneToMany
   @JoinColumn(name="Departements_id")
    List<Employee>employe;
    
    
    
     private Departements(){

    }

    private Departements(Builder builder) {
        id=builder.id;
        name= builder.name;
        employe=builder.employe;
        dephistory =builder.dephistory;

    }

    public static class Builder{
        private Long id;
    private String name;
    private DepartementHistory dephistory;
    List<Employee>employe;
    

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }
         public Builder dephistory(DepartementHistory value){
            dephistory=value;
            return this;
        }

        public Builder employe(List<Employee> value){
            employe=value;
            return this;
        }
        

        public Departements build(){
            return new Departements(this);
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

    public List<Employee> getEmploye() {
        return employe;
    }

    public void setEmploye(List<Employee> employe) {
        this.employe = employe;
    }

    public DepartementHistory getDephistory() {
        return dephistory;
    }

    public void setDephistory(DepartementHistory dephistory) {
        this.dephistory = dephistory;
    }

   
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Departements other = (Departements) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tchouyangoko.humain.domain.Departements[ id=" + id + " ]";//"Departements{" + "id=" + id + ", name=" + name + ", employe=" + employe + ", dephistory=" + dephistory + '}';
    }

    
}
