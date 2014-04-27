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
public class Qualification implements Serializable{
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
    private String name;
    
   private Qualification(){

    }

    private Qualification(Builder builder) {
        id=builder.id;
        name= builder.name;
      
    }

    public static class Builder{
        private Long id;
    private String name;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            id=value;
            return this;
        }

          public Builder name(Qualification value){
            id = value.getId();
            name = value.getName();           
            return this;
        }

        public Qualification build(){
            return new Qualification(this);
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
        int hash = 5;
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
        final Qualification other = (Qualification) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       return "com.tchouyangoko.humain.domain.Qualification[ id=" + id + " ]";//return "Qualification{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
