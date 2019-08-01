package com.spring.data.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.model.Employee;
import com.spring.data.repository.EmployeeRepository;

@RestController
public class EmpController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void addEmp() {
		
		List<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee(373,"Baswant",new String[]{"Hyderabad","HYD"}));
		emp.add(new Employee(543,"Kiran",new String[]{"Hyderabad","HYD"}));
		emp.add(new Employee(224,"Sumit",new String[]{"Hyderabad","HYD"}));
		
		employeeRepository.saveAll(emp);
	}
	
	@GetMapping("/getAll")
	public Iterable<Employee> getList(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/getEmp/{name}")
	public Employee getEmpByName(@PathVariable String name) {
		return employeeRepository.findByName(name);
	}
}
