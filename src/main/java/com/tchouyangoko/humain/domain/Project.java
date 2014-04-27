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
public  class Project implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name="Project_id")
    List<ProjectAssign>projetassign;
    
    private Project()
    {
        
    }
    
    private Project(Builder builder)
    {
        id=builder.id;
        name=builder.name;
        description=builder.description;
      projetassign =builder.projetassign;
    }
    
    public static class Builder{
        private Long id;
    private String name;
    private String description;
    List<ProjectAssign>projetassign;
    
    
    public Builder(String name,String description)
    {
        this.name=name;
        this.description=description;
    }
       
    public Builder id(Long value)
    {
        id=value;
        return this;
    }
    public Builder projetassign(List<ProjectAssign>value)
    {
        projetassign=value;
        return this;
    }
    
   
    
     public Builder street_address(Project value){
            id = value.getId();
            name = value.getName();
            description = value.getDescription();
            projetassign =value.projetassign;
            
            return this;
        }
    public Project build()
    {
        return new Project(this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProjectAssign> getProjetassign() {
        return projetassign;
    }

    public void setProjetassign(List<ProjectAssign> projetassign) {
        this.projetassign = projetassign;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Project other = (Project) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       return "com.tchouyangoko.humain.domain.Project[ id=" + id + " ]";//return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", projetassign=" + projetassign + '}';
    }
    
    
}
