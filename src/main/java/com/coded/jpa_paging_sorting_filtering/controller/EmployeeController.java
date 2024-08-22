package com.coded.jpa_paging_sorting_filtering.controller;

import com.coded.jpa_paging_sorting_filtering.model.Employee;
import com.coded.jpa_paging_sorting_filtering.model.EmployeePage;
import com.coded.jpa_paging_sorting_filtering.model.EmployeeSearchCriteria;
import com.coded.jpa_paging_sorting_filtering.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployee(EmployeePage employeePage,
                                                      EmployeeSearchCriteria employeeSearchCriteria) {
        return new ResponseEntity<>(employeeService.getEmployees(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }
}
