package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import com.example.demo.entity.Role;

@Entity
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	private String password;
	
	@OneToOne
	private Role role;
	
	@OneToOne
	private Employee employee;
	
}
