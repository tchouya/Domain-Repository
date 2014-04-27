/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.Project;
import com.tchouyangoko.humain.repository.ProjectRepository;
import com.tchouyangoko.humain.services.crud.ProjetCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */

@Service
public class ProjetCrudServiceImpl implements ProjetCrudService{
   @Autowired
    private ProjectRepository projetRepository;
    

    @Override
    public List<Project> getTotalProject() {
        return projetRepository.findAll();
        } 
}