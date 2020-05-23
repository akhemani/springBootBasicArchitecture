package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Page<Address> findAll(Pageable pageable) {
		return addressRepository.findAll(pageable);
	}

	@Override
	public Page<Address> findAll(Specification<Address> specification, Pageable pageable) {
		return addressRepository.findAll(specification, pageable);
	}

	@Override
	public List<Address> findAll(Specification<Address> specification) {
		return addressRepository.findAll(specification);
	}

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address save(Address entity) {
		return addressRepository.save(entity);
	}

	@Override
	public Address findById(Long id) {
		return addressRepository.findById(id).get();
	}

	@Override
	public Long deleteById(Long id) {
		addressRepository.deleteById(id);
		return id;
	}
	
}
