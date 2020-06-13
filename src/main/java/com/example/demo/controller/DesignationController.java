package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Message;
import com.example.demo.common.Response;
import com.example.demo.common.ResultCode;
import com.example.demo.repository.DesignationRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/designation")
public class DesignationController {
	
	@Autowired
	private DesignationRepository designationRepository;

	@GetMapping
	@ApiOperation(value = "get all designations")
	public ResponseEntity<Response> getAllDesignations(Pageable pageable) {
		return new ResponseEntity<>(new Response(ResultCode.SUCCESS, designationRepository.findAll(pageable), Message.SUCCESS), HttpStatus.OK);
	}
	
}
