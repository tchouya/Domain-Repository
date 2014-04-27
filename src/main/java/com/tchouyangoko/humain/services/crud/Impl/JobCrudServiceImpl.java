/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.Job;
import com.tchouyangoko.humain.repository.JobRepository;
import com.tchouyangoko.humain.services.crud.JobCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mikiahidjo
 */
public class JobCrudServiceImpl implements JobCrudService{
  @Autowired
    private JobRepository jobRepository;
    

    @Override
    public List<Job> getTotalJob() {
        return jobRepository.findAll();
        }
      
}
