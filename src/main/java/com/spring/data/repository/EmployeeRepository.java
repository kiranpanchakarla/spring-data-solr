package com.spring.data.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.spring.data.model.Employee;

public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer>{

	Employee findByName(String name);

}
