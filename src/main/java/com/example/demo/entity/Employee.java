package com.example.demo.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int age;
	
	private Long salary;

	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
	private Address address;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Department department;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
}
