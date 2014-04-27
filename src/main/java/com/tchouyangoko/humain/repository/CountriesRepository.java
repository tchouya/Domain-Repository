/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.repository;

import com.tchouyangoko.humain.domain.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mikiahidjo
 */
@Repository
public interface CountriesRepository  extends JpaRepository<Countries,Long>{
    
}
