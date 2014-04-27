/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.Skill;
import com.tchouyangoko.humain.repository.SkillRepository;
import com.tchouyangoko.humain.services.crud.SkillCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */

@Service
public class SkillCrudServiceImpl implements SkillCrudService{
   @Autowired
    private SkillRepository skillRepository;
    

    @Override
    public List<Skill> getTotalSkill() {
        return skillRepository.findAll();
        } 
}