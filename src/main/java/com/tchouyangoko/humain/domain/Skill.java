/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
public class Skill implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany
    @JoinColumn(name="Skill_id")        
    List< Qualification> qualification;
    
     private Skill(){

    }

    private Skill(Builder builder) {
        id=builder.id;
        name= builder.name;
        qualification=builder.qualification;

    }

    public static class Builder{
        private Long id;
    private String name;
    
    List<Qualification>qualification;
    
        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }

        public Builder qualification(List<Qualification> value){
            qualification=value;
            return this;
        }

        public Skill build(){
            return new Skill(this);
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

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Skill other = (Skill) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Qualification> getQualification() {
        return qualification;
    }

    public void setQualification(List<Qualification> qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name=" + name + ", qualification=" + qualification + '}';
    }

}
