package com.ust.assignment_2.service;

import com.ust.assignment_2.model.Employee;
import com.ust.assignment_2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> getExpDevs(){
        return employeeRepository.getExperiencedEmployee();
    }
}
