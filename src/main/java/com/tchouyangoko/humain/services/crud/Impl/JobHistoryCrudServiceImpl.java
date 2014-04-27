/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.JobHistory;
import com.tchouyangoko.humain.repository.JobHistoryRepository;
import com.tchouyangoko.humain.services.crud.CountriesCrudService;
import com.tchouyangoko.humain.services.crud.JobHistoryCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */
@Service
public class JobHistoryCrudServiceImpl implements JobHistoryCrudService{
    
    @Autowired
    private JobHistoryRepository jobHistoryRepository;
    

    @Override
    public List<JobHistory> getTotalJobHistory() {
        return jobHistoryRepository.findAll();
        }
    
}

