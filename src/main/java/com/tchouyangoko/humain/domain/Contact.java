/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author mikiahidjo
 */
@Embeddable
public  class Contact implements Serializable {
    
     private String landline;
    private String address;
    private String cell;
   
    
   private Contact ()
     {
      
      }
     

    private Contact(Builder builder) {
        landline=builder.landline;
        address= builder.address;
        cell = builder.cell;
      
    }

    public static class Builder{
    private String landline;
    private String address;
    private String cell;

       
         public Builder(String address,String cell) {
            this.address = address;
            this.cell=cell;
        }
         

        public Builder landline(String value){
            landline=value;
            return this;
        }

          public Builder name(Contact value){
            landline = value.getLandline();  
            address = value.getAddress();
            cell = value.getCell();           
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

   /* @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.landline);
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.landline, other.landline)) {
            return false;
        }
        return true;
    }*/
    
    
}
