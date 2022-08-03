package com.springboot.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app1.model.Employee;

// A repository is a mechanism for encapsulating storage, 
// retrieval, and search behavior which emulates a collection of objects
// You can see that this is a repository for Employee with A primary key that is type long
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
//This file is good