/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.Location;
import com.tchouyangoko.humain.repository.LocationRepository;
import com.tchouyangoko.humain.services.crud.LocationCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */
@Service
public class LocationCrudServiceImpl implements LocationCrudService{
   @Autowired
    private LocationRepository locationRepository;
    

    @Override
    public List<Location> getTotalLocation() {
        return locationRepository.findAll();
        } 
}
