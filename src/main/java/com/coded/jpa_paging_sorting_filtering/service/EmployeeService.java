package com.coded.jpa_paging_sorting_filtering.service;


import com.coded.jpa_paging_sorting_filtering.repository.EmployeeCriteriaRepository;
import com.coded.jpa_paging_sorting_filtering.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeCriteriaRepository employeeCriteriaRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCriteriaRepository = employeeCriteriaRepository;
    }
}




