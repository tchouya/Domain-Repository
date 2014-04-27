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

/**
 *
 * @author mikiahidjo
 */
@Embeddable
public class Region implements Serializable {
    
    private Long id;
private String name;


 private Region(){

    }

    private Region(Builder builder) {
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

       
        
        public Builder name(Region value){
            id = value.getId();
            name = value.getName();
            return this;
        }

        public Region build(){
            return new Region(this);
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


   
    
}
