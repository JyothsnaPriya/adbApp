package com.verizon.sdma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sdma.dao.EmployeeRepository;
import com.verizon.sdma.model.Employee;

@Service
public class EmployeeServiceImpl implements EmpService {
	
	@Autowired
	private EmployeeRepository empDAO;

	@Override
	public Employee getEmpId(long empId) {
		Optional<Employee> opt = empDAO.findById((int) empId);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDAO.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDAO.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return empDAO.save(employee);
	}

	@Override
	public boolean deleteEmployee(long empId) {
		boolean isDeleted=false;
		if(empDAO.existsById((int) empId)) {
			empDAO.deleteById((int) empId);
			isDeleted=true;
		}
		return isDeleted;
		
	}

	@Override
	public boolean existsByMobileNum(String mobileNum) {
		// TODO Auto-generated method stub
		return empDAO.existsByMobileNum(mobileNum);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return empDAO.existsByEmailId(emailId);
	}

	@Override
	public Employee findByMobileNum(String mobileNum) {
		// TODO Auto-generated method stub
		return empDAO.findByMobileNum(mobileNum);
	}

	@Override
	public Employee findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return empDAO.findByEmailId(emailId);
	}

	/*@Override
	public List<Employee> findAllByLastName(String lastName) {
		// TODO Auto-generated method stub
		return empDAO.findAllByLastName(lastName);
	}*/

}
