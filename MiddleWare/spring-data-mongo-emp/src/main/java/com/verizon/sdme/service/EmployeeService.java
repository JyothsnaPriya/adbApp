package com.verizon.sdme.service;

import java.util.List;

import com.verizon.sdme.model.EmployeeMongo;

public interface EmployeeService {
	public void addEmployeeMongo(EmployeeMongo employee);
	public void removeEmployeeMongo(int empId);
	public void updateEmployeeMongo(EmployeeMongo employee);
	public EmployeeMongo getEmployeeMongo(int empId);
	public List<EmployeeMongo> getEmployeeMongos();
	public boolean exists(int empId);

}
