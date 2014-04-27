/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.Office;
import com.tchouyangoko.humain.repository.OfficeRepository;
import com.tchouyangoko.humain.services.crud.OfficeCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */

@Service
public class OfficeCrudServiceImpl implements OfficeCrudService{
   @Autowired
    private OfficeRepository officeRepository;
    

    @Override
    public List<Office> getTotalOffice() {
        return officeRepository.findAll();
        } 
}