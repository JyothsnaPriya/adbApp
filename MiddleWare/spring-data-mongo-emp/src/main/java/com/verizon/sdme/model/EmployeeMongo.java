package com.verizon.sdme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="mongoemps")
public class EmployeeMongo {
	
	@Id
	private int empId;	
	private String empName;	
	private double empBasic;	
	
	public EmployeeMongo(){	
		super();
	}	
	public EmployeeMongo(int empId, String empName, double empBasic) {		
		super();		
		this.empId = empId;		
		this.empName = empName;		
		this.empBasic = empBasic;	
		}	
	public int getempId() {		
		return empId;	
		}	
	public void setempId(int empId) {		
		this.empId = empId;	
		}	
	public String getempName() {		
		return empName;	
		}	
	public void setempName(String empName) {		
		this.empName = empName;	
		}	
	public double getempBasic() {		
		return empBasic;	
		}	
	public void setempBasic(double empBasic) {		
		this.empBasic = empBasic;	
		}	
	@Override	
	public String toString() {		
		return "EmployeeMongo [empId=" + empId + ", empName=" + empName + ", empBasic=" + empBasic + "]";	
		}			


}
