<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title>Add Contact</title>
		<link href="styles/site.css" rel="stylesheet"/>
	</head>
<body>
	<h2>Employee Form</h2>

	<form:form modelAttribute="employee" action="addEmployee" method="POST">
		<table>
		<tr>
				<td><form:label path="empId">Employee ID</form:label></td>
				<td><form:input path="empId" />
				<form:errors path="empId"></form:errors></td>
			</tr>
		
			<tr>
				<td><form:label path="empName">Employee Name</form:label></td>
				<td><form:input path="empName" />
				<form:errors path="empName"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:radiobuttons items="${genders}" path="gender" /> 
				<form:errors path="gender"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="basic">Basic</form:label></td>
				<td><form:input path="basic" />
				<form:errors path="basic"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="hra">HRA</form:label></td>
				<td><form:input path="hra" />
				<form:errors path="hra"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="dept">Department</form:label></td>
				<td><form:input path="dept" />
				<form:errors path="dept"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="emailId">Email</form:label></td>
				<td><form:input path="emailId" /> 
				<form:errors path="emailId"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="mobileNum">Mobile Number</form:label>
				</td>
				<td><form:input path="mobileNum" /> 
				<form:errors path="mobileNum"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="dob">Date Of Birth</form:label></td>
				<td><form:input type="date" path="dob" />
				<form:errors path="dob"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<button>Add Employee</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>