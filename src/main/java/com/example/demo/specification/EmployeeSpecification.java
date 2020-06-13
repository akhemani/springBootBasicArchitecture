package com.example.demo.specification;

import javax.persistence.criteria.Predicate;
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
	
	public static Specification<Employee> filterEmployee(Employee emp) {
		return (root, query, criteriaBuilder) -> {
			
			Predicate p1 = criteriaBuilder.and();
			Predicate p2 = criteriaBuilder.and();
			Predicate p3 = criteriaBuilder.and();
			Predicate p4 = criteriaBuilder.and();
			
			if (emp.getDepartment().getId() != null) {
				p1 = criteriaBuilder.equal(root.get("department"), emp.getDepartment().getId());
			}
			
			if (emp.getStatus() != -1) {
				p2 = criteriaBuilder.equal(root.get("status"), emp.getStatus());
			}
			
			if (emp.getDesignation().getId() != null) {
				p3 = criteriaBuilder.equal(root.get("designation"), emp.getDesignation().getId());
			}
			
			if (emp.getDateOfJoining() != null) {
				p4 = criteriaBuilder.equal(root.get("dateOfJoining"), emp.getDateOfJoining());
			}
			
			return criteriaBuilder.and(p1, p2, p3, p4);
		};
	}
}
