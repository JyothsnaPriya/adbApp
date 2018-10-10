package com.verizon.sdma.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sdma.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
	
	boolean existsByMobileNum(String mobileNum);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNum(String mobileNum);
	Employee findByEmailId(String emailId);
	
//	List<Employee> findAllByLastName(String lastName);
	
	
}
