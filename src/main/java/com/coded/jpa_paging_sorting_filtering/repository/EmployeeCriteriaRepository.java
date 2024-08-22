package com.coded.jpa_paging_sorting_filtering.repository;


import com.coded.jpa_paging_sorting_filtering.model.Employee;
import com.coded.jpa_paging_sorting_filtering.model.EmployeePage;
import com.coded.jpa_paging_sorting_filtering.model.EmployeeSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public EmployeeCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Employee> findAllWithFilters(EmployeePage employeePage,
                                             EmployeeSearchCriteria employeeSearchCriteria) {
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate predicate = getPredicate(employeeSearchCriteria, employeeRoot);
        criteriaQuery.where(predicate);
        setOrder(employeePage, criteriaQuery, employeeRoot);
    }


    private Predicate getPredicate(EmployeeSearchCriteria employeeSearchCriteria,
                                   Root<Employee> employeeRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(employeeSearchCriteria.getFirstName())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("firstName"),
                            "%" + employeeSearchCriteria.getFirstName() + "%")
            );
        }
        if(Objects.nonNull(employeeSearchCriteria.getLastName())) {
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("lastName"),
                            "%" + employeeSearchCriteria.getLastName() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }


