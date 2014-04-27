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
public class DepartementHistory implements Serializable {
    
     private Long id;
    private String name;
    
     private DepartementHistory(){

    }

    private DepartementHistory(Builder builder) {
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

       

        public DepartementHistory build(){
            return new DepartementHistory(this);
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

  /*  @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final DepartementHistory other = (DepartementHistory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DepartementHistory{" + "id=" + id + ", name=" + name + '}';
    }
*/
}
