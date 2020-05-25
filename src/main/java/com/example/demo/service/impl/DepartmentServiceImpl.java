package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Page<Department> findAll(Pageable pageable) {
		return departmentRepository.findAll(pageable);
	}

	@Override
	public Page<Department> findAll(Specification<Department> specification, Pageable pageable) {
		return departmentRepository.findAll(specification, pageable);
	}

	@Override
	public List<Department> findAll(Specification<Department> specification) {
		return departmentRepository.findAll(specification);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department save(Department entity) {
		return departmentRepository.save(entity);
	}

	@Override
	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public Long deleteById(Long id) {
		departmentRepository.deleteById(id);
		return id;
	}

}
