/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tchouyangoko.humain.services.crud.Impl;

import com.tchouyangoko.humain.domain.Employee;
import com.tchouyangoko.humain.repository.EmployeeRepository;
import com.tchouyangoko.humain.services.crud.EmployeeCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikiahidjo
 */
@Service
public class EmployeeCrudServiceImpl implements EmployeeCrudService{
  
    @Autowired
    private EmployeeRepository employeeRepository;
    

    @Override
    public List<Employee> getTotalEmployee() {
        return employeeRepository.findAll();
        }
    
}
