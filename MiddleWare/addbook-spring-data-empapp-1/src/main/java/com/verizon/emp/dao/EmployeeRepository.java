package com.verizon.emp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	boolean existsByMobileNum(String mobileNum);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNum(String mobileNum);
	Employee findByEmailId(String emailId);
	
//	List<Employee> findAllByLastName(String lastName);
	
	
}
