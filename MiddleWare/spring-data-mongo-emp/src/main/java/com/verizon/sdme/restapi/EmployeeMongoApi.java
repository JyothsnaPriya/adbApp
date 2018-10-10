package com.verizon.sdme.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.sdme.model.EmployeeMongo;
import com.verizon.sdme.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeMongoApi {
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeMongo>> getAllEmployeeMongos(){
		ResponseEntity<List<EmployeeMongo>> resp =null;
		List<EmployeeMongo> employees= service.getEmployeeMongos();
		if(employees!=null && employees.size()>0)
			resp = new ResponseEntity<List<EmployeeMongo>>(employees, HttpStatus.OK);
		else 
			resp = new ResponseEntity<List<EmployeeMongo>>(employees, HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<EmployeeMongo> getEmployeeMongo(@PathVariable("empid")int empid){
		ResponseEntity<EmployeeMongo> resp = null;
		EmployeeMongo employee= service.getEmployeeMongo(empid);
		if(employee!=null)
			resp=new ResponseEntity<EmployeeMongo>(employee,HttpStatus.OK);
		else 	
			resp=new ResponseEntity<EmployeeMongo>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeMongo> addEmployeeMongo(@RequestBody EmployeeMongo employee){
		ResponseEntity<EmployeeMongo> resp = null;
		
		if(employee!=null && !service.exists(employee.getempId())){
			service.addEmployeeMongo(employee);
			resp=new ResponseEntity<EmployeeMongo>(employee,HttpStatus.OK);
		}
		else 	
			resp=new ResponseEntity<EmployeeMongo>(HttpStatus.CONFLICT);
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<EmployeeMongo> updateEmployeeMongo(@RequestBody EmployeeMongo employee){
		ResponseEntity<EmployeeMongo> resp = null;
		
		if(employee!=null && service.exists(employee.getempId())){
			service.updateEmployeeMongo(employee);
			resp=new ResponseEntity<EmployeeMongo>(employee,HttpStatus.OK);
		}
		else 	
			resp=new ResponseEntity<EmployeeMongo>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@DeleteMapping("/{empid}")
	public ResponseEntity<Void> deEmployeeMongo(@PathVariable("empid") int empid){
		ResponseEntity<Void> resp = null;
		
		if( service.exists(empid)){
			service.removeEmployeeMongo(empid);
			resp=new ResponseEntity<>(HttpStatus.OK);
		}
		else 	
			resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	
} 
