package com.example.demo.controller;


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
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import io.swagger.annotations.ApiOperation;

// @CrossOrigin
@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {

	@Autowired
	public DepartmentService deptService;
	
	@ApiOperation(value = "create an Department")
	@PostMapping()
	public ResponseEntity<Response> saveDepartment(@RequestBody Department Department) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, deptService.save(Department), Message.CREATED), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Response> getAllDepartmentsWithPagination(Pageable pageable) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, deptService.findAll(pageable), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllDepartments() {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, deptService.findAll(), Message.SUCCESS), HttpStatus.OK);
	}
	
	@GetMapping("byId/{id}")
	public ResponseEntity<Response> getDepartmentById(@PathVariable Long id) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, deptService.findById(id), Message.SUCCESS), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Response> updateDepartment(@RequestBody Department Department) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, deptService.save(Department), Message.UPDATED), HttpStatus.OK);
	}
	
	@DeleteMapping("/byId/{id}")
	public ResponseEntity<Response> deleteDepartment(@PathVariable Long id) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, deptService.deleteById(id), Message.DELETED), HttpStatus.OK);
	}
	
}
