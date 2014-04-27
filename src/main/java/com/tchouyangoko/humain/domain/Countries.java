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
public  class Countries implements Serializable {

   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
  
  @Embedded
  private Region region;
   @OneToMany
   @JoinColumn(name="countries_id")
   List<Location> location;
 /* public  Countries()
     {
      
      }*/
  
   private Countries()
     {
      
      }
     private Countries(Builder builder)
     {
         id=builder.id;
         name=builder.name;
         region =builder.region;
         location =builder.location;
     }

   
       public static class Builder{
          private Long id;
           private String name;
             private Region region;
             List<Location> location;
           
     public Builder(String name){
         this.name=name;
        }
      
       public Builder id(Long value){
          id=value;
        return this;
            }
       public Builder region(Region value){
          region=value;
        return this;
            }
       
      
        public Builder location(List<Location>  value){
          location=value;
        return this;
            }
       
        public Builder name(Countries value){
            id = value.getId();
            name = value.getName();
            region = value.getRegion();
            location = value.getLocation();
             return this;
        }

         public Countries build(){
            return new Countries(this);
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
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
        final Countries other = (Countries) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tchouyangoko.humain.domain.Counties[ id=" + id + " ]";
    }

       
}
