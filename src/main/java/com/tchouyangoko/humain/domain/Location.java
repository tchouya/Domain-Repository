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
public class Location implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street_address;
    private String city;
    @OneToMany
    @JoinColumn(name="Location_id")
    List<Departements> departement;
    
    private Location()
    {
        
    }
    
    private Location(Builder builder)
    {
        id=builder.id;
        street_address=builder.street_address;
        city=builder.city;
        departement=builder.departement;
    }
    
    public static class Builder{
    private Long id;
    private String street_address;
    private String city;
    
    List<Departements>departement;
    
    public Builder(String street_address,String city){
        this.street_address=street_address;
        this.city=city;
    }
      
    
    public Builder id(Long value){
        id=value;
        return this;
    }
    
    
    
     public Builder street_address(Location value){
            id = value.getId();
            street_address = value.getStreet_address();
            city = value.getCity();
            departement =value.departement;
            return this;
        }
    
    public Location build()
    {
        return new Location(this);
    }
 }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Departements> getDepartement() {
        return departement;
    }

    public void setDepartement(List<Departements> departement) {
        this.departement = departement;
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
      return "com.tchouyangoko.humain.domain.Location[ id=" + id + " ]"; // return "Location{" + "id=" + id + ", street_address=" + street_address + ", city=" + city + ", departement=" + departement + '}';
    }

   
}
