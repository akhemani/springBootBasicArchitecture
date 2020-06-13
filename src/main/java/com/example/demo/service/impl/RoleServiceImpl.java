package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	@Override
	public Page<Role> findAll(Specification<Role> specification, Pageable pageable) {
		return roleRepository.findAll(specification, pageable);
	}

	@Override
	public List<Role> findAll(Specification<Role> specification) {
		return roleRepository.findAll(specification);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role entity) {
		return roleRepository.save(entity);
	}

	@Override
	public Role findById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public Long deleteById(Long id) {
		roleRepository.deleteById(id);
		return id;
	}

}
