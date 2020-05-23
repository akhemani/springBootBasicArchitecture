package com.example.demo.model;

import java.util.Date;
import com.example.demo.entity.Address;
import com.example.demo.entity.Department;
import lombok.Data;

public @Data class EmployeeFilter {

	private String name;
	
	private int age;
	
	private Long salary;
	
	private Address address;
	
	private Department department;
	
	private Date dateOfJoining;
	
}
