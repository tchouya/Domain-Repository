/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.ProjectAssign;
import com.tchouyangoko.humain.repository.ProjectAssignRepository;
import com.tchouyangoko.humain.services.crud.ProjetAssignCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */



@Service
public class ProjetAssignCrudServiceImpl implements ProjetAssignCrudService{
   @Autowired
    private ProjectAssignRepository projetAssignRepository;
    

    @Override
    public List<ProjectAssign> getTotalProjectAssign() {
        return projetAssignRepository.findAll();
        
        } 
}