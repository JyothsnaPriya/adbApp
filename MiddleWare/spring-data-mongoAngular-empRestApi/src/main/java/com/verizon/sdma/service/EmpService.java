package com.verizon.sdma.service;

import java.util.List;

import com.verizon.sdma.model.Employee;

public interface EmpService {

	Employee getEmpId(long empId);
	List<Employee> getAllEmployee();
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(long empId);
	
	boolean existsByMobileNum(String mobileNum);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNum(String mobileNum);
	Employee findByEmailId(String emailId);
	
	//List<Employee> findAllByLastName(String lastName);
}
