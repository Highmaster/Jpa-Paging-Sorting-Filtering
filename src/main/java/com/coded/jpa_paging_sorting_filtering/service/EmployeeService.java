package com.coded.jpa_paging_sorting_filtering.service;


import com.coded.jpa_paging_sorting_filtering.model.Employee;
import com.coded.jpa_paging_sorting_filtering.model.EmployeePage;
import com.coded.jpa_paging_sorting_filtering.model.EmployeeSearchCriteria;
import com.coded.jpa_paging_sorting_filtering.repository.EmployeeCriteriaRepository;
import com.coded.jpa_paging_sorting_filtering.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeCriteriaRepository employeeCriteriaRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCriteriaRepository = employeeCriteriaRepository;
    }

    public Page<Employee> getEmployees(EmployeePage employeePage,
                                       EmployeeSearchCriteria employeeSearchCriteria) {
        return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);

    }

    public Employee getEmployee(Employee employee) {
        return  employeeRepository.save(employee);

    }
}




