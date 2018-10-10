package com.verizon.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.emp.dao.EmployeeRepository;
import com.verizon.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmpService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee getEmpId(long empId) {
		Employee employee=null;
		if(empRepo.existsById(empId)) {
			employee = empRepo.findById(empId).get();
			
		}
		Optional<Employee> optContact=empRepo.findById(empId);
		if(optContact.isPresent()) {
			employee = optContact.get();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	@Override
	public boolean deleteEmployee(long empId) {
		boolean isDeleted=false;
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			isDeleted=true;
		}
		return isDeleted;
		
	}

	@Override
	public boolean existsByMobileNum(String mobileNum) {
		// TODO Auto-generated method stub
		return empRepo.existsByMobileNum(mobileNum);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return empRepo.existsByEmailId(emailId);
	}

	@Override
	public Employee findByMobileNum(String mobileNum) {
		// TODO Auto-generated method stub
		return empRepo.findByMobileNum(mobileNum);
	}

	@Override
	public Employee findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return empRepo.findByEmailId(emailId);
	}

	/*@Override
	public List<Employee> findAllByLastName(String lastName) {
		// TODO Auto-generated method stub
		return empRepo.findAllByLastName(lastName);
	}*/

}
