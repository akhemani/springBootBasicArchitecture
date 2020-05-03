package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	public EmployeeService empService;
	
	@ApiOperation(value = "create an employee")
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(empService.save(employee), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Page<Employee>> getAllEmployeesWithPagination(Pageable pageable) {
		return new ResponseEntity<>(empService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(empService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("byId/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<>(empService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(empService.save(employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/byId/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		empService.deleteById(id);
	}
	
}
