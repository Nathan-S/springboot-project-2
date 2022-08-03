package com.springboot.app1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app1.model.Employee;
import com.springboot.app1.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee REST API
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//http://localhost:8080/api/employees/1
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId) {
		
		employeeService.deleteEmployee(employeeId);
		
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}
}