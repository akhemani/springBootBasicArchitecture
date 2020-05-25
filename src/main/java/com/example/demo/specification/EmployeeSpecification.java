package com.example.demo.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.demo.entity.Employee;

public class EmployeeSpecification {
	public static Specification<Employee> searchEmployee(String searchText) {
		return (root, query, criteriaBuilder) -> {			
			String toSearchText = "%" + searchText + "%";
			return criteriaBuilder.and(criteriaBuilder.or(						
										criteriaBuilder.like(root.get("name"), toSearchText),
										criteriaBuilder.like(root.get("age").as(String.class), toSearchText),
										criteriaBuilder.like(root.get("dateOfJoining").as(String.class), toSearchText),
										criteriaBuilder.like(root.get("address").get("address"), toSearchText),
										criteriaBuilder.like(root.get("department").get("name"), toSearchText),
										criteriaBuilder.like(root.get("address").get("city"), toSearchText)
									  )
					);
		};
	}
}
