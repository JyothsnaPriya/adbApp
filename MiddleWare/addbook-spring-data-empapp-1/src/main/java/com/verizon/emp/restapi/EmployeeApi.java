package com.verizon.emp.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.emp.model.Employee;
import com.verizon.emp.service.EmpService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeApi {

	@Autowired
	private EmpService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllContacts() {
		return new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long empId) {
		ResponseEntity<Employee> resp;
		Employee c = service.getEmpId(empId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Employee>> getAllContacts(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {

		ResponseEntity<List<Employee>> resp;

		switch (fieldBy) {
		case "mobileNumber":
			Employee cByMobNum = service.findByMobileNum(searchValue);
			if (cByMobNum != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByMobNum), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "emailId":
			Employee cByEmail = service.findByEmailId(searchValue);
			if (cByEmail != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByEmail), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
	
		default:
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			break;
		}

		return resp;
	}

	@PostMapping
	public ResponseEntity<Employee> addContact(@RequestBody Employee contact) {
		ResponseEntity<Employee> resp = null;

		if (service.existsByEmailId(contact.getEmailId())) {
			resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
		}

		if (service.existsByMobileNum(contact.getMobileNum())) {
			resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
		}

		if (resp == null) {
			Employee c = service.addEmployee(contact);
			if (c == null)
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Employee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Employee> updateContact(@RequestBody Employee contact) {
		ResponseEntity<Employee> resp = null;

		Employee c = service.getEmpId(contact.getEmpId());
		if (!contact.getEmailId().equals(c.getEmailId())) {
			if (service.existsByEmailId(contact.getEmailId())) {
				resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
			}
		}

		if (!contact.getMobileNum().equals(c.getMobileNum())) {
			if (service.existsByMobileNum(contact.getMobileNum())) {
				resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
			}
		}

		if (resp == null) {
			c = service.updateEmployee(contact);
			if (c == null)
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Employee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") long contactId) {
		ResponseEntity<Void> resp = null;

		if (service.deleteEmployee(contactId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
}
