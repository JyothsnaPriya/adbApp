package com.verizon.sdme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sdme.dao.EmployeeMongoRepository;
import com.verizon.sdme.model.EmployeeMongo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMongoRepository employeeDAO;

	@Override
	public void addEmployeeMongo(EmployeeMongo employee) {
		employeeDAO.insert(employee);
		
	}

	@Override
	public void removeEmployeeMongo(int empId) {
		employeeDAO.deleteById(empId);
		
	}

	@Override
	public void updateEmployeeMongo(EmployeeMongo employee) {
		employeeDAO.save(employee);
		
	}

	@Override
	public EmployeeMongo getEmployeeMongo(int empId) {
		Optional<EmployeeMongo> opt = employeeDAO.findById(empId);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<EmployeeMongo> getEmployeeMongos() {
		return employeeDAO.findAll();
	}

	@Override
	public boolean exists(int empId) {
		return employeeDAO.existsById(empId);
	}
	

}
