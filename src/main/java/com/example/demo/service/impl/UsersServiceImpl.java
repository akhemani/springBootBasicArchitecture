package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Users;
import com.example.demo.model.Login;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public Page<Users> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public Page<Users> findAll(Specification<Users> specification, Pageable pageable) {
		return userRepository.findAll(specification, pageable);
	}

	@Override
	public List<Users> findAll(Specification<Users> specification) {
		return userRepository.findAll(specification);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Users save(Users entity) {
		return userRepository.save(entity);
	}

	@Override
	public Users findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public Long deleteById(Long id) {
		userRepository.deleteById(id);
		return id;
	}

	@Override
	public Users login(Login loginDetails) {
		return userRepository.findByUserNameAndPasswordAndRole(loginDetails.getUsername(), loginDetails.getPassword(), roleService.findById(loginDetails.getType()));
	}

}
