package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public Page<Employee> findAll(Pageable pageable) {
		return empRepository.findAll(pageable);
	}

	@Override
	public Page<Employee> findAll(Specification<Employee> specification, Pageable pageable) {
		return empRepository.findAll(specification, pageable);
	}

	@Override
	public List<Employee> findAll(Specification<Employee> specification) {
		return empRepository.findAll(specification);
	}

	@Override
	public List<Employee> findAll() {
		return empRepository.findAll();
	}

	@Override
	public Employee save(Employee entity) {
		return empRepository.save(entity);
	}

	@Override
	public Employee findById(Long id) {
		return empRepository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		empRepository.deleteById(id);
	}
	
}
