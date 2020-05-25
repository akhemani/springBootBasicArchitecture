package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.Message;
import com.example.demo.common.Response;
import com.example.demo.common.ResultCode;
import com.example.demo.entity.Address;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.AddressService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.example.demo.specification.EmployeeSpecification;
import io.swagger.annotations.ApiOperation;

// @CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	public EmployeeService empService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@ApiOperation(value = "create an employee")
	@PostMapping()
	public ResponseEntity<Response> saveEmployee(@RequestBody Employee employee) {		
//		Employee emp = empService.findById(employee.getId());		// for testing only
//		if (emp != null) {
//			return new ResponseEntity<>(new Response(ResultCode.ERROR, ResultCode.ALREADY_EXISTS.toString()), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.save(employee), "Succesfully Created"), HttpStatus.OK);
//		}
		
		Address add = employee.getAddress();
		employee.setAddress(addressService.save(add));
		
		Department dept = employee.getDepartment();
		employee.setDepartment(departmentService.save(dept));
		
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.save(employee), Message.CREATED), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Response> getAllEmployeesWithPagination(Pageable pageable, HttpServletResponse response) {
		//response.setHeader("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.findAll(pageable), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllEmployees() {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.findAll(), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("byId/{id}")
	public ResponseEntity<Response> getEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.findById(id), Message.SUCCESS), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Response> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.save(employee), Message.UPDATED), HttpStatus.OK);
	}
	
	@DeleteMapping("/byId/{id}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable Long id) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.deleteById(id), Message.DELETED), HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchedText}")
	public ResponseEntity<Response> searchText(@PathVariable String searchedText, Pageable pageable) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, empService.findAll(EmployeeSpecification.searchEmployee(searchedText), pageable), Message.SUCCESS), HttpStatus.OK);		
	}
	
}
