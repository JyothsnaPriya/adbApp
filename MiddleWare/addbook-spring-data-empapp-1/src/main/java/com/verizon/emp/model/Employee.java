package com.verizon.emp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="employees")
public class Employee {

	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long empId;
		
		@NotEmpty(message="empName can not be empty")
		@Size(min=5,max=15,message="empName must be of 5 to 15 chars")
		private String empName;
		
		/*@NotEmpty(message="lastName can not be empty")
		@Size(min=5,max=15,message="lastName must be of 5 to 15 chars")
		private String lastName;
		*/
		@DateTimeFormat(iso=ISO.DATE)
		@NotNull(message="Date of birth can not be left blank")
		@Column(name="dob")
		private LocalDate dob;
		
		@NotEmpty(message="Email Id can not be NULL")
		@Email(message="Invalid Email Id")
		private String emailId;
		
		@NotEmpty(message="Mobile number can not be null")
		@Pattern(regexp="\\d{10}",message="mobile number can be only 10 digits")
		@Column(name="Ph.No")
		private String mobileNum;
		
		@Enumerated(EnumType.STRING)
		private Gender gender;
		
		private double basic;
		private double hra;
		private String dept;

		
		public double getHra() {
			return hra;
		}
		public void setHra(double hra) {
			this.hra = hra;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public double getBasic() {
			return basic;
		}
		public void setBasic(double basic) {
			this.basic = basic;
		}
		public long getEmpId() {
			return empId;
		}
		public void setEmpId(long empId) {
			this.empId = empId;
		}
		
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getMobileNum() {
			return mobileNum;
		}
		public void setMobileNum(String mobileNum) {
			this.mobileNum = mobileNum;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		
		
}
