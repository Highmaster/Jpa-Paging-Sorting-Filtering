package com.coded.jpa_paging_sorting_filtering.repository;

import com.coded.jpa_paging_sorting_filtering.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
